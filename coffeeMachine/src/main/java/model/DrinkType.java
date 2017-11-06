package model;

public enum DrinkType {

    COFFEE("coffee", 0.6), TEA("tea", 0.4), CHOCOLATE("chocolate", 0.5), ORANGE_JUICE("orange juice", 0.6);

    private String drinkLabel;
    private double drinkCost;

    DrinkType(String drinkLabel, double drinkCost) {
        this.drinkLabel = drinkLabel;
        this.drinkCost = drinkCost;
    }

    public String getDrinkLabel() {
        return drinkLabel;
    }

    public boolean isHotDrink() {
        return this.equals(COFFEE) || this.equals(TEA) || this.equals(CHOCOLATE);
    }

    public double calculateBeneficeByDrinkType(int numberOfDrinkMade) {
        return this.drinkCost*numberOfDrinkMade;
    }

    public boolean isThereSufficientMoney(double paymentAmount) {
        return this.drinkCost <= paymentAmount;
    }
}
