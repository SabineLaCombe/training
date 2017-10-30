public class DrinkOrder {

    private DrinkType drinkType;
    private int numberOfSugar;
    private double paymentAmount;
    private boolean extraHot;

    DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    String createMessageToDrinkMaker() {
        if(paymentAmount < drinkType.getDrinkCost()) {
            return MessageTemplate.NOT_ENOUGH_MONEY;
        }
        return MessageTemplate.createMessageToDrinkMaker(drinkType, numberOfSugar, extraHot);
    }

    void addSugarAndStick(int quantity) {
        this.numberOfSugar = quantity;
    }

    void putMoney(double amount) {
        this.paymentAmount = amount;
    }

    public void isExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }
}