package repository;

import model.DrinkType;

import java.text.MessageFormat;

public class DrinkReport {

    private final CoffeeReport coffeeReport;
    private final TeaReport teaReport;
    private final ChocolateReport chocolateReport;
    private final OrangeJuiceReport orangeJuiceReport;

    public DrinkReport() {
        coffeeReport = new CoffeeReport();
        teaReport = new TeaReport();
        chocolateReport = new ChocolateReport();
        orangeJuiceReport = new OrangeJuiceReport();
    }

    public void countDrinks(DrinkType drinkType) {
        switch (drinkType) {
            case COFFEE:
                coffeeReport.count();
                break;
            case TEA:
                teaReport.count();
                break;
            case CHOCOLATE:
                chocolateReport.count();
                break;
            case ORANGE_JUICE:
                orangeJuiceReport.count();
                break;
        }
    }

    public String getDrinkSoldReport() {
        return MessageFormat.format("{0} coffee made\n {1} tea made\n {2} chocolate made\n {3} orange juice made\n {4} benefice in total\n",
            coffeeReport.numberOfCoffeeMade, teaReport.numberOfTeaMade, chocolateReport.numberOfChocolateMade, orangeJuiceReport.numberOfOrangeJuiceMade, calculateBenefice());
    }

    private String calculateBenefice() {
        return Double.toString(coffeeReport.calculateBenefice() + teaReport.calculateBenefice() + chocolateReport.calculateBenefice() + orangeJuiceReport.calculateBenefice());
    }
}
