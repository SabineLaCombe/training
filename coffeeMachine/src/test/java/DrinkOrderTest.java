import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkOrderTest {

    private static final String DRINK_MAKER_MAKES_1_COFFEE = "Drink maker makes 1 coffee with no sugar(s) and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_TEA = "Drink maker makes 1 tea with no sugar(s) and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_CHOCOLATE = "Drink maker makes 1 chocolate with no sugar(s) and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_COFFEE_WITH_1_SUGAR = "Drink maker makes 1 coffee with 1 sugar(s) and a stick";
    private static final String DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR = "Drink maker makes 1 coffee with 2 sugar(s) and a stick";
    private static final Object DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR_AND_A_STICK = "Drink maker makes 1 coffee with 2 sugar(s) and a stick";

    @Test
    public void should_send_one_coffee_order_when_customer_order_coffe() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE);
    }

    @Test
    public void should_send_one_tea_order_when_customer_order_tea() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.TEA);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_TEA);
    }

    @Test
    public void should_send_one_chocolate_order_when_customer_order_chocolate() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.CHOCOLATE);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_CHOCOLATE);
    }

    @Test
    public void should_send_one_coffee_with_one_sugar_order_to_coffee_maker() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.addSugarAndStick(1);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE_WITH_1_SUGAR);
    }

    @Test
    public void should_send_one_coffee_with_two_sugar_order_to_coffee_maker() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.addSugarAndStick(2);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR);
    }

    @Test
    public void should_send_one_coffee_with_two_sugar_and_one_stick_order_to_coffee_maker() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.addSugarAndStick(2);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR_AND_A_STICK);
    }
}