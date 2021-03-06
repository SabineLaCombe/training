package repository;

import model.DrinkType;

public class ChocolateReport implements Report{

    private int numberOfChocolateMade;

    public void count() {
        numberOfChocolateMade++;
    }

    public double calculateBenefice() {
        return DrinkType.CHOCOLATE.calculateBeneficeByDrinkType(numberOfChocolateMade);
    }

    public int getNumberOfChocolateMade() {
        return numberOfChocolateMade;
    }
}