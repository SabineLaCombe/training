import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkOrderTest {

    private static final String DRINK_MAKER_MAKES_1_COFFEE = "Drink maker makes 1 coffee with no sugar(s) and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_TEA = "Drink maker makes 1 tea with no sugar(s) and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_CHOCOLATE = "Drink maker makes 1 chocolate with no sugar(s) and therefore no stick";
    private static final String DRINK_MAKER_MAKES_1_COFFEE_WITH_1_SUGAR = "Drink maker makes 1 coffee with 1 sugar(s) and a stick";
    private static final String DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR = "Drink maker makes 1 coffee with 2 sugar(s) and a stick";
    private static final String DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR_AND_A_STICK = "Drink maker makes 1 coffee with 2 sugar(s) and a stick";
    private static final String NOT_ENOUGH_MONEY = "Not enough money";
    private static final String DRINK_MAKER_MAKES_1_EXTRA_HOT_COFFEE = "Drink maker makes 1 extra hot coffee with no sugar(s) and therefore no stick";

    @Test
    public void should_send_one_coffee_order_when_customer_order_coffee() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.putMoney(0.6);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE);
    }

    @Test
    public void should_send_one_tea_order_when_customer_order_tea() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.TEA);
        drinkOrder.putMoney(0.4);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_TEA);
    }

    @Test
    public void should_send_one_chocolate_order_when_customer_order_chocolate() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.CHOCOLATE);
        drinkOrder.putMoney(0.5);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_CHOCOLATE);
    }

    @Test
    public void should_send_one_coffee_with_one_sugar_order_to_coffee_maker() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.addSugarAndStick(1);
        drinkOrder.putMoney(0.6);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE_WITH_1_SUGAR);
    }

    @Test
    public void should_send_one_coffee_with_two_sugar_order_to_coffee_maker() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.addSugarAndStick(2);
        drinkOrder.putMoney(0.6);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR);
    }

    @Test
    public void should_send_one_coffee_with_two_sugar_and_one_stick_order_to_coffee_maker() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.addSugarAndStick(2);
        drinkOrder.putMoney(0.6);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_COFFEE_WITH_2_SUGAR_AND_A_STICK);
    }

    @Test
    public void should_not_sent_coffee_order_to_drink_maker_when_not_enough_money() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.putMoney(0.5);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(NOT_ENOUGH_MONEY);
    }

    @Test
    public void should_not_sent_tea_order_to_drink_maker_when_not_enough_money() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.TEA);
        drinkOrder.putMoney(0.3);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(NOT_ENOUGH_MONEY);
    }

    @Test
    public void should_not_sent_chocolate_order_to_drink_maker_when_not_enough_money() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.CHOCOLATE);
        drinkOrder.putMoney(0.4);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(NOT_ENOUGH_MONEY);
    }

    @Test
    public void should_send_one_orange_juice_order_when_customer_order_orange_juice() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.ORANGE_JUICE);
        drinkOrder.putMoney(0.6);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo("Drink maker makes 1 orange juice");
    }

    @Test
    public void should_send_one_extra_hot_coffee_when_customer_order_extra_hot_coffee() {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.putMoney(0.6);
        drinkOrder.isExtraHot(true);
        assertThat(drinkOrder.createMessageToDrinkMaker()).isEqualTo(DRINK_MAKER_MAKES_1_EXTRA_HOT_COFFEE);
    }

    @Test
    public void should_report_two_drinks_sold_when_two_drinks_ordered() throws Exception {
        DrinkOrder drinkOrder = new DrinkOrder(DrinkType.COFFEE);
        drinkOrder.putMoney(0.6);
        DrinkReport drinkReport = new DrinkReport();
        assertThat(drinkReport.getDrinkSoldCount()).isEqualTo(2);
    }
}