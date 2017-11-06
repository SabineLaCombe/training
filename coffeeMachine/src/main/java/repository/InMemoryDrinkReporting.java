package repository;

import model.DrinkType;

import java.text.MessageFormat;

public class InMemoryDrinkReporting implements DrinkReporting {

    private static final String REPORTING_TEMPLATE = "{0} coffee made\n {1} tea made\n {2} chocolate made\n {3} orange juice made\n {4} benefice in total\n";

    private final CoffeeReport coffeeReport;
    private final TeaReport teaReport;
    private final ChocolateReport chocolateReport;
    private final OrangeJuiceReport orangeJuiceReport;

    public InMemoryDrinkReporting() {
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
        return MessageFormat.format(REPORTING_TEMPLATE,
            coffeeReport.getNumberOfCoffeeMade(),
            teaReport.getNumberOfTeaMade(),
            chocolateReport.getNumberOfChocolateMade(),
            orangeJuiceReport.getNumberOfOrangeJuiceMade(),
            calculateBenefice());
    }

    private String calculateBenefice() {
        return Double.toString(coffeeReport.calculateBenefice() + teaReport.calculateBenefice() + chocolateReport.calculateBenefice() + orangeJuiceReport.calculateBenefice());
    }
}
