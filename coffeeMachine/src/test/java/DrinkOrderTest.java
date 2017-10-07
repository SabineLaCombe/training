import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DrinkOrderTest {

    @Test
    public void should_send_one_coffee_order_when_asked_by_customer() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        String message = drinkOrder.createMessageToDrinkMaker();
        assertThat(message).isEqualTo("Drink maker makes one coffee");
    }

    @Test
    public void should_send_one_tea_order_when_asked_by_customer() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.TEA );
        String message = drinkOrder.createMessageToDrinkMaker();
        assertThat(message).isEqualTo("Drink maker makes one tea");
    }
}
