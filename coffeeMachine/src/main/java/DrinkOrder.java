public class DrinkOrder {

    private DrinkType drinkType;
    private int numberOfSugar;

    private static final String MESSAGE_TO_DRINK_MAKER_PATTERN = "Drink maker makes 1 ";
    private static final String ADD_ONE_SUGAR_AND_A_STICK_TO_TEMPLATE_MESSAGE = " with 1 sugar and a stick";
    private static final String ADD_TWO_SUGARS_AND_A_STICK_TO_MESSAGE_TEMPLATE = " with 2 sugars and a stick";
    private static final String ADD_NO_SUGAR_AND_NO_STICK = " with no sugar and therefore no stick";

    DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    String createMessageToDrinkMaker() {
        StringBuilder message = new StringBuilder(MESSAGE_TO_DRINK_MAKER_PATTERN + drinkType.getDrinkLabel());
        message = addSugarAndStickOrderToMessage(message);
        return message.toString();
    }

    private StringBuilder addSugarAndStickOrderToMessage(StringBuilder message) {
        if(numberOfSugar == 1) {
            return message.append(ADD_ONE_SUGAR_AND_A_STICK_TO_TEMPLATE_MESSAGE);
        } else if (numberOfSugar == 2) {
            return message.append(ADD_TWO_SUGARS_AND_A_STICK_TO_MESSAGE_TEMPLATE);
        } else {
            return message.append(ADD_NO_SUGAR_AND_NO_STICK);
        }
    }

    void addSugar(int quantity) {
        numberOfSugar = quantity;
    }
}