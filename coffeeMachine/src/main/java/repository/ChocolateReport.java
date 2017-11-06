package repository;

import model.DrinkType;

public class ChocolateReport implements Report{

    private int numberOfChocolateMade;

    public void count() {
        numberOfChocolateMade++;
    }

    public double calculateBenefice() {
        return DrinkType.CHOCOLATE.calculateBenefice(numberOfChocolateMade);
    }

    public int getNumberOfChocolateMade() {
        return numberOfChocolateMade;
    }
}