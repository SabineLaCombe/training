import java.text.MessageFormat;

public class MessageTemplate {

    static final String ORDER_MESSAGE_PATTERN = "Drink maker makes 1 {0} with {1} sugar(s) and {2} stick";
    static final String NO_SUGAR = "no";
    static final String NO_STICK = "therefore no";
    static final String ONE_STICK = "a";

    static String createMessageToDrinkMaker(DrinkType drinkType, int numberOfSugar) {
        String sugar = numberOfSugar != 0 ? Integer.toString(numberOfSugar) : NO_SUGAR;
        String stick = numberOfSugar != 0 ? ONE_STICK : NO_STICK;
        return MessageFormat.format(ORDER_MESSAGE_PATTERN, drinkType.getDrinkLabel(), sugar, stick);
    }
}