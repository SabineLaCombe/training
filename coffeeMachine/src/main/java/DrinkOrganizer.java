public class DrinkOrganizer {

    private DrinkReport drinkReport;

    DrinkOrganizer() {
        drinkReport = new DrinkReport();
    }

    String getDrinkMadeReport() {
        return drinkReport.getDrinkMadeReport();
    }

    String sendCommand(DrinkOrder drinkOrder) {
        String drinkMakerMessage = drinkOrder.createMessageToDrinkMaker();
        if(!drinkMakerMessage.equals(OrderMessageTemplate.NOT_ENOUGH_MONEY))
            drinkReport.countDrinkMade();
        return drinkMakerMessage;
    }
}
