import model.DrinkOrder;
import model.DrinkType;
import model.OrderMessageTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repository.DrinkReporting;
import repository.InMemoryDrinkReporting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DrinkOrganizerTest {

    private static final String NOT_ENOUGH_MONEY = "Not enough money";
    private static final String ONE_DOLLAR_BENEFIT_IN_TOTAL = "1.0 benefice in total";
    private static final String ONE_COFFEE_MADE_DURING_THE_DAY = "1 coffee made";
    private static final String ONE_TEA_MADE_DURING_THE_DAY = "1 tea made";
    private static final String ONE_CHOCOLATE_MADE_DURING_THE_DAY = "1 chocolate made";
    private static final String ONE_ORANGE_JUICE_MADE_DURING_THE_DAY = "1 orange juice made";

    private DrinkOrganizer drinkOrganizer;

    @Mock
    private BeverageQuantityChecker beverageQuantityChecker;

    @Mock
    private EmailNotifier emailNotifier;

    @Before
    public void setUp() throws Exception {
        DrinkReporting drinkReporting = new InMemoryDrinkReporting();
        drinkOrganizer = new DrinkOrganizer(drinkReporting, beverageQuantityChecker, emailNotifier);
    }

    @Test
    public void should_not_sent_coffee_order_to_drink_maker_when_not_enough_money() {
        DrinkOrder drinkOrder = DrinkOrder.createBasicDrink(DrinkType.COFFEE, 0.5);

        String message = drinkOrganizer.sendCommand(drinkOrder);

        assertThat(message).isEqualTo(NOT_ENOUGH_MONEY);
    }

    @Test
    public void should_not_sent_tea_order_to_drink_maker_when_not_enough_money() {
        DrinkOrder drinkOrder = DrinkOrder.createBasicDrink(DrinkType.TEA, 0.3);

        String message = drinkOrganizer.sendCommand(drinkOrder);

        assertThat(message).isEqualTo(NOT_ENOUGH_MONEY);
    }

    @Test
    public void should_not_sent_chocolate_order_to_drink_maker_when_not_enough_money() {
        DrinkOrder drinkOrder = DrinkOrder.createBasicDrink(DrinkType.CHOCOLATE, 0.4);

        String message = drinkOrganizer.sendCommand(drinkOrder);

        assertThat(message).isEqualTo(NOT_ENOUGH_MONEY);
    }

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

        assertThat(drinkOrganizer.getDrinkSoldReport())
            .containsOnlyOnce(ONE_DOLLAR_BENEFIT_IN_TOTAL)
            .containsOnlyOnce(ONE_COFFEE_MADE_DURING_THE_DAY)
            .containsOnlyOnce(ONE_TEA_MADE_DURING_THE_DAY);
    }

    @Test
    public void should_report_shortage() {
        DrinkOrder firstDrinkOrder = DrinkOrder.createBasicDrink(DrinkType.COFFEE, 0.6);
        when(beverageQuantityChecker.isEmpty(DrinkType.COFFEE)).thenReturn(true);

        String message = drinkOrganizer.sendCommand(firstDrinkOrder);

        assertThat(message).containsOnlyOnce(OrderMessageTemplate.SHORTAGE_MESSAGE);
    }

    @Test
    public void should_report_email_has_been_sent_when_shortages_of_stock() {
        DrinkOrder firstDrinkOrder = DrinkOrder.createBasicDrink(DrinkType.COFFEE, 0.6);
        when(beverageQuantityChecker.isEmpty(DrinkType.COFFEE)).thenReturn(true);

        String message = drinkOrganizer.sendCommand(firstDrinkOrder);

        verify(emailNotifier, times(1)).notifyMissingDrink(DrinkType.COFFEE);
    }
}
