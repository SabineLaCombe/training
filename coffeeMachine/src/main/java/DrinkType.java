
public enum DrinkType {

    COFFEE("coffee", 0.6), TEA("tea", 0.4), CHOCOLATE("chocolate", 0.5);

    private String drinkLabel;
    private double drinkCost;

    DrinkType(String drinkLabel, double drinkCost) {
        this.drinkLabel = drinkLabel;
        this.drinkCost = drinkCost;
    }

    public String getDrinkLabel() {
        return drinkLabel;
    }

    public double getDrinkCost() {
        return drinkCost;
    }
}
