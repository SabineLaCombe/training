package model;

public class DrinkOrder {

    private DrinkType drinkType;
    private int numberOfSugar;
    private boolean extraHot;
    private double paymentAmount;

    private DrinkOrder(DrinkType drinkType, int numberOfSugar, boolean extraHot, double paymentAmount) {
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
        this.extraHot = extraHot;
        this.paymentAmount = paymentAmount;
    }

    public static DrinkOrder createBasicDrink(DrinkType drinkType, double paymentAmount) {
        return new DrinkOrder(drinkType, 0, false, paymentAmount);
    }

    public static DrinkOrder createHotDrink(DrinkType drinkType, int numberOfSugar, double paymentAmount) {
        return new DrinkOrder(drinkType, numberOfSugar, false, paymentAmount);
    }

    public static DrinkOrder createExtraHotDrink(DrinkType drinkType, int numberOfSugar, double paymentAmount) {
        return new DrinkOrder(drinkType, numberOfSugar, true, paymentAmount);
    }

    public String createMessageToDrinkMaker() {
        if(paymentAmount < drinkType.getDrinkCost()) {
            return OrderMessageTemplate.NOT_ENOUGH_MONEY;
        }
        return OrderMessageTemplate.createMessageToDrinkMaker(drinkType, numberOfSugar, extraHot);
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }
}