import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DrinkOrderTest {

    @Test
    public void should_send_one_coffee_order_when_asked_by_customer() {
        DrinkOrder drinkOrder = new DrinkOrder("coffee");
        String message = drinkOrder.createMessageToDrinkMaker();
        assertThat(message).isEqualTo("Drink maker makes one coffee");
    }
}
