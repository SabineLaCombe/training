public class DrinkOrder {

    private DrinkType drinkType;
    private int numberOfSugar;
    private boolean extraHot;
    private double paymentAmount;

    DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    String createMessageToDrinkMaker() {
        if(paymentAmount < drinkType.getDrinkCost()) {
            return OrderMessageTemplate.NOT_ENOUGH_MONEY;
        }
        return OrderMessageTemplate.createMessageToDrinkMaker(drinkType, numberOfSugar, extraHot);
    }

    void addSugarAndStick(int quantity) {
        this.numberOfSugar = quantity;
    }

    void putMoney(double amount) {
        this.paymentAmount = amount;
    }

    void isExtraHot() {
        this.extraHot = true;
    }
}