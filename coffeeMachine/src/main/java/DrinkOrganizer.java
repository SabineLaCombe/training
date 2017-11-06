import model.DrinkOrder;
import model.OrderMessageTemplate;
import repository.DrinkReport;

public class DrinkOrganizer {

    private DrinkReport drinkReport;

    DrinkOrganizer() {
        drinkReport = new DrinkReport();
    }

    String getDrinkSoldReport() {
        return drinkReport.getDrinkSoldReport();
    }

    String sendCommand(DrinkOrder drinkOrder) {
        String drinkMakerMessage = drinkOrder.createMessageToDrinkMaker();
        if(!drinkMakerMessage.equals(OrderMessageTemplate.NOT_ENOUGH_MONEY))
            drinkReport.countDrinks(drinkOrder.getDrinkType());
        return drinkMakerMessage;
    }
}
