import model.DrinkOrder;
import model.DrinkType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkOrganizerTest {

    public static final String ONE_DOLLAR_BENEFIT_IN_TOTAL = "1.0 benefice in total";
    private static final String ONE_COFFEE_MADE_DURING_THE_DAY = "1 coffee made";
    private static final String ONE_TEA_MADE_DURING_THE_DAY = "1 tea made";
    private static final String ONE_CHOCOLATE_MADE_DURING_THE_DAY = "1 chocolate made";
    private static final String ONE_ORANGE_JUICE_MADE_DURING_THE_DAY = "1 orange juice made";

    DrinkOrganizer drinkOrganizer = new DrinkOrganizer();

    @Test
    public void should_report_one_coffee_made() {
        DrinkOrder drinkOrder = DrinkOrder.createBasicDrink(DrinkType.COFFEE, 0.6);

        drinkOrganizer.sendCommand(drinkOrder);

        assertThat(drinkOrganizer.getDrinkSoldReport()).containsOnlyOnce(ONE_COFFEE_MADE_DURING_THE_DAY);
    }

    @Test
    public void should_report_one_tea_made() {
        DrinkOrder drinkOrder = DrinkOrder.createBasicDrink(DrinkType.TEA, 0.4);

        drinkOrganizer.sendCommand(drinkOrder);

        assertThat(drinkOrganizer.getDrinkSoldReport()).containsOnlyOnce(ONE_TEA_MADE_DURING_THE_DAY);
    }

    @Test
    public void should_report_one_chocolate_made() {
        DrinkOrder drinkOrder = DrinkOrder.createBasicDrink(DrinkType.CHOCOLATE, 0.5);

        drinkOrganizer.sendCommand(drinkOrder);

        assertThat(drinkOrganizer.getDrinkSoldReport()).containsOnlyOnce(ONE_CHOCOLATE_MADE_DURING_THE_DAY);
    }

    @Test
    public void should_report_one_orange_juice_made() {
        DrinkOrder drinkOrder = DrinkOrder.createBasicDrink(DrinkType.ORANGE_JUICE, 0.6);

        drinkOrganizer.sendCommand(drinkOrder);

        assertThat(drinkOrganizer.getDrinkSoldReport()).containsOnlyOnce(ONE_ORANGE_JUICE_MADE_DURING_THE_DAY);
    }

    @Test
    public void should_report_benefit_for_one_coffee_and_one_tea() {
        DrinkOrder firstDrinkOrder = DrinkOrder.createBasicDrink(DrinkType.COFFEE, 0.6);
        DrinkOrder secondDrinkOrder = DrinkOrder.createBasicDrink(DrinkType.TEA, 0.4);

        drinkOrganizer.sendCommand(firstDrinkOrder);
        drinkOrganizer.sendCommand(secondDrinkOrder);

        assertThat(drinkOrganizer.getDrinkSoldReport()).containsOnlyOnce(ONE_DOLLAR_BENEFIT_IN_TOTAL);
    }
}
