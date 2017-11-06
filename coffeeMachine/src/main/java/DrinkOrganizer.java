import model.DrinkOrder;
import model.OrderMessageTemplate;
import repository.DrinkReporting;

public class DrinkOrganizer {

    private DrinkReporting drinkReporting;
    private BeverageQuantityChecker beverageQuantityChecker;

    DrinkOrganizer(DrinkReporting drinkReporting, BeverageQuantityChecker beverageQuantityChecker) {
        this.drinkReporting = drinkReporting;
        this.beverageQuantityChecker = beverageQuantityChecker;
    }

    String getDrinkSoldReport() {
        return drinkReporting.getDrinkSoldReport();
    }

    String sendCommand(DrinkOrder drinkOrder) {
        if (areStocksEmpty(drinkOrder)) {
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
