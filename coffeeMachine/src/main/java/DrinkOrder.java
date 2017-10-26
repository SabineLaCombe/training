
public class DrinkOrder {

    private DrinkType drinkType;

    public static final String MESSAGE_TO_DRINK_MAKER_PATTERN = "Drink maker makes one ";

    public DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String createMessageToDrinkMaker() {
        return MESSAGE_TO_DRINK_MAKER_PATTERN + drinkType.getDrinkLabel();
    }
}
