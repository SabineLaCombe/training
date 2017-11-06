import model.DrinkOrder;
import model.DrinkType;
import model.OrderMessageTemplate;
import repository.DrinkReporting;

public class DrinkOrganizer {

    private DrinkReporting drinkReporting;
    private BeverageQuantityChecker beverageQuantityChecker;
    private EmailNotifier emailNotifier;

    DrinkOrganizer(DrinkReporting drinkReporting, BeverageQuantityChecker beverageQuantityChecker, EmailNotifier emailNotifier) {
        this.drinkReporting = drinkReporting;
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.emailNotifier = emailNotifier;
    }

    String getDrinkSoldReport() {
        return drinkReporting.getDrinkSoldReport();
    }

    String sendCommand(DrinkOrder drinkOrder) {
        if (areStocksEmpty(drinkOrder)) {
            return sendMailAndCreateMessageWhenStockEmpty(drinkOrder.getDrinkType());
        }
        if (isMoneyNotSufficient(drinkOrder)) {
            return OrderMessageTemplate.NOT_ENOUGH_MONEY;
        }
        return sendCommandToDrinkMaker(drinkOrder);
    }

    private String sendCommandToDrinkMaker(DrinkOrder drinkOrder) {
        drinkReporting.countDrinks(drinkOrder.getDrinkType());
        return drinkOrder.createMessageToDrinkMaker();
    }

    private String sendMailAndCreateMessageWhenStockEmpty(DrinkType drinkType) {
        emailNotifier.notifyMissingDrink(drinkType);
        return OrderMessageTemplate.SHORTAGE_MESSAGE;
    }

    private boolean isMoneyNotSufficient(DrinkOrder drinkOrder) {
        return !drinkOrder.isThereSufficientMoney();
    }

    private boolean areStocksEmpty(DrinkOrder drinkOrder) {
        return beverageQuantityChecker.isEmpty(drinkOrder.getDrinkType());
    }
}
