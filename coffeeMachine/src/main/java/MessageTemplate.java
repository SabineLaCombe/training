import java.text.MessageFormat;

public class MessageTemplate {

    static final String HOT_DRINK_ORDER_MESSAGE_PATTERN = "Drink maker makes 1 {0} with {1} sugar(s) and {2} stick";
    static final String COLD_DRINK_ORDER_MESSAGE_PATTERN = "Drink maker makes 1 {0}";

    static final String NO_SUGAR = "no";
    static final String NO_STICK = "therefore no";

    static final String ONE_STICK = "a";
    static final String NOT_ENOUGH_MONEY = "Not enough money";

    static String createMessageToDrinkMaker(DrinkType drinkType, int numberOfSugar) {
        if(drinkType.isHotDrink()) {
            return createMessageForHotDrink(drinkType, numberOfSugar);
        }
        return createMessageForColdDrink(drinkType);
    }

    private static String createMessageForColdDrink(DrinkType drinkType) {
        return MessageFormat.format(COLD_DRINK_ORDER_MESSAGE_PATTERN, drinkType.getDrinkLabel());
    }

    private static String createMessageForHotDrink(DrinkType drinkType, int numberOfSugar) {
        String sugar = numberOfSugar != 0 ? Integer.toString(numberOfSugar) : NO_SUGAR;
        String stick = numberOfSugar != 0 ? ONE_STICK : NO_STICK;
        return MessageFormat.format(HOT_DRINK_ORDER_MESSAGE_PATTERN, drinkType.getDrinkLabel(), sugar, stick);
    }
}