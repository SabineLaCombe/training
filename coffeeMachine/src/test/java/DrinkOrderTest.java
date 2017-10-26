import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DrinkOrderTest {

    public static final String DRINK_MAKER_MAKES_ONE_COFFEE = "Drink maker makes 1 coffee";
    public static final String DRINK_MAKER_MAKES_ONE_TEA = "Drink maker makes 1 tea";
    public static final String DRINK_MAKER_MAKES_ONE_CHOCOLATE = "Drink maker makes 1 chocolate";

    @Test
    public void should_send_one_coffee_order_when_customer_order_coffe() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_ONE_COFFEE);
    }

    @Test
    public void should_send_one_tea_order_when_customer_order_tea() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.TEA);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_ONE_TEA);
    }

    @Test
    public void should_send_one_chocolate_order_when_customer_order_chocolate() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.CHOCOLATE);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_ONE_CHOCOLATE);
    }
}
