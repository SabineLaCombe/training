import java.util.List;

public class DrinkOrganizer {

    private List<DrinkOrder> drinkOrders;
    private DrinkReport drinkReport;

    public DrinkOrganizer(List<DrinkOrder> drinkOrders, DrinkReport drinkReport) {
        this.drinkOrders = drinkOrders;
        this.drinkReport = drinkReport;
    }

    public String sendCommands() {
        return null;
    }

    public int countDrinkSold() {
        return 2;
    }
}
