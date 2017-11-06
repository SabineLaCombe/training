import model.DrinkOrder;
import model.OrderMessageTemplate;
import repository.DrinkReporting;

public class DrinkOrganizer {

    private DrinkReporting drinkReporting;

    DrinkOrganizer(DrinkReporting drinkReporting) {
        this.drinkReporting = drinkReporting;
    }

    String getDrinkSoldReport() {
        return drinkReporting.getDrinkSoldReport();
    }

    String sendCommand(DrinkOrder drinkOrder) {
        String drinkMakerMessage = drinkOrder.createMessageToDrinkMaker();
        if(!drinkMakerMessage.equals(OrderMessageTemplate.NOT_ENOUGH_MONEY))
            drinkReporting.countDrinks(drinkOrder.getDrinkType());
        return drinkMakerMessage;
    }
}
