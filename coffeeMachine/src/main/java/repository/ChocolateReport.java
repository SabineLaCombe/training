package repository;

import model.DrinkType;

public class ChocolateReport implements Report{

    int numberOfChocolateMade;

    public void count() {
        numberOfChocolateMade++;
    }

    public double calculateBenefice() {
        return DrinkType.CHOCOLATE.calculateBenefice(numberOfChocolateMade);
    }
}