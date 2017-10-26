
public enum DrinkType {

    COFFEE("coffee"), TEA("tea"), CHOCOLATE("chocolate");

    private String drinkLabel;

    DrinkType(String drinkLabel) {
        this.drinkLabel = drinkLabel;
    }

    public String getDrinkLabel() {
        return drinkLabel;
    }
}
