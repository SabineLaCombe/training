import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DrinkOrder {

    private DrinkType drinkType;
    private int numberOfSugar;

    public static final String MESSAGE_TO_DRINK_MAKER_PATTERN = "Drink maker makes 1 ";

    public DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String createMessageToDrinkMaker() {
        String message = MESSAGE_TO_DRINK_MAKER_PATTERN + drinkType.getDrinkLabel();
        if(numberOfSugar == 1) {
            message += " with 1 sugar";
        } else if(numberOfSugar == 2) {
            message += " with 2 sugars";
        }
        return message;
    }

    public void addSugar(int quantity) {
        numberOfSugar = quantity;
    }
}