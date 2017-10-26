import java.text.MessageFormat;

public class DrinkOrder {

    private DrinkType drinkType;
    private String numberOfSugar;
    private String stick;

    private static final String ORDER_MESSAGE_PATTERN = "Drink maker makes 1 {0} with {1} sugar(s) and {2} stick";
    private static final String NO_SUGAR = "no";
    private static final String NO_STICK = "therefore no";
    private static final String ONE_STICK = "a";

    DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
        this.numberOfSugar = NO_SUGAR;
        this.stick = NO_STICK;
    }

    String createMessageToDrinkMaker() {
        return MessageFormat.format(ORDER_MESSAGE_PATTERN, drinkType.getDrinkLabel(), numberOfSugar, stick);
    }

    void addSugarAndStick(int quantity) {
        numberOfSugar = Integer.toString(quantity);
        stick = ONE_STICK;
    }
}