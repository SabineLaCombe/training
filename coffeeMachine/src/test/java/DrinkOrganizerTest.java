import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkOrganizerTest {

    public static final String ONE_COFFEE_MADE_DURING_THE_DAY = "1 coffee made";
    private static final String ONE_TEA_MADE_DURING_THE_DAY = "1 tea made";

    @Test
    public void should_report_one_coffee_made() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.putMoney(0.6);
        DrinkOrganizer drinkOrganizer = new DrinkOrganizer();

        drinkOrganizer.sendCommand(drinkOrder);

        assertThat(drinkOrganizer.getDrinkMadeReport()).containsOnlyOnce(ONE_COFFEE_MADE_DURING_THE_DAY);
    }

    @Test
    public void should_report_two_drink_made() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.TEA);
        drinkOrder.putMoney(0.4);
        DrinkOrganizer drinkOrganizer = new DrinkOrganizer();

        drinkOrganizer.sendCommand(drinkOrder);

        assertThat(drinkOrganizer.getDrinkMadeReport()).containsOnlyOnce(ONE_TEA_MADE_DURING_THE_DAY);
    }
}
