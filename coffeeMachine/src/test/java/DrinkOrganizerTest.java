import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkOrganizerTest {

    public static final String ONE_COFFEE_MADE_DURING_THE_DAY = "1 coffee made during the day";

    @Test
    public void should_report_one_drink_made() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.putMoney(0.6);
        DrinkOrganizer drinkOrganizer = new DrinkOrganizer();

        drinkOrganizer.sendCommand(drinkOrder);

        assertThat(drinkOrganizer.getDrinkMadeReport()).isEqualTo(ONE_COFFEE_MADE_DURING_THE_DAY);
    }
}
