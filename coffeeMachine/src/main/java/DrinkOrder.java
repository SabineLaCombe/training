public class DrinkOrder {

    private DrinkType drinkType;
    private int numberOfSugar;

    DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    String createMessageToDrinkMaker() {
        return MessageTemplate.createMessageToDrinkMaker(drinkType, numberOfSugar);
    }

    void addSugarAndStick(int quantity) {
        numberOfSugar = quantity;
    }
}