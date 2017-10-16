import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DrinkOrderTest {

    public static final String DRINK_MAKER_MAKES_ONE_COFFEE = "Drink maker makes one coffee";
    public static final String DRINK_MAKER_MAKES_ONE_TEA = "Drink maker makes one tea";

    @Test
    public void should_send_one_coffee_order_when_asked_by_customer() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_ONE_COFFEE);
    }

    @Test
    public void should_send_one_tea_order_when_asked_by_customer() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.TEA );
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_ONE_TEA);
    }
}
