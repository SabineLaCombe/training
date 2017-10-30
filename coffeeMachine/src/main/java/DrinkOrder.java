public class DrinkOrder {

    private DrinkType drinkType;
    private int numberOfSugar;
    private double paymentAmount;

    DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    String createMessageToDrinkMaker() {
        if(paymentAmount < 0.6) {
            return "Not enough money";
        }
        return MessageTemplate.createMessageToDrinkMaker(drinkType, numberOfSugar);
    }

    void addSugarAndStick(int quantity) {
        numberOfSugar = quantity;
    }

    void putMoney(double amount) {
        paymentAmount = amount;
    }
}