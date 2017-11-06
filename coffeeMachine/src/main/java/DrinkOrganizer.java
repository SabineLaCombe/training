import model.DrinkOrder;
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
            emailNotifier.notifyMissingDrink(drinkOrder.getDrinkType());
            return OrderMessageTemplate.SHORTAGE_MESSAGE;
        }
        if (isThereSufficientMoney(drinkOrder)) {
            drinkReporting.countDrinks(drinkOrder.getDrinkType());
            return drinkOrder.createMessageToDrinkMaker();
        }
        return OrderMessageTemplate.NOT_ENOUGH_MONEY;
    }

    private boolean isThereSufficientMoney(DrinkOrder drinkOrder) {
        return drinkOrder.isThereSufficientMoney();
    }

    private boolean areStocksEmpty(DrinkOrder drinkOrder) {
        return beverageQuantityChecker.isEmpty(drinkOrder.getDrinkType());
    }
}
