import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DrinkOrderTest {

    private static final String DRINK_MAKER_MAKES_1_COFFEE = "Drink maker makes 1 coffee with no sugar and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_TEA = "Drink maker makes 1 tea with no sugar and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_CHOCOLATE = "Drink maker makes 1 chocolate with no sugar and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_COFFEE_WITH_1_SUGAR = "Drink maker makes 1 coffee with 1 sugar and a stick";
    private static final String DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR = "Drink maker makes 1 coffee with 2 sugars and a stick";

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
    public void should_send_one_coffee_with_one_sugar_order_to_coffee_maker() throws Exception {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.addSugar(1);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE_WITH_1_SUGAR);
    }

    @Test
    public void should_send_one_coffee_with_two_sugar_order_to_coffee_maker() throws Exception {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.addSugar(2);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR);
    }
}