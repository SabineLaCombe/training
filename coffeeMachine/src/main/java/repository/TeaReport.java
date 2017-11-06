package repository;

import model.DrinkType;

public class TeaReport implements Report {

    private int numberOfTeaMade;

    public void count() {
        numberOfTeaMade++;
    }

    public double calculateBenefice() {
        return DrinkType.TEA.calculateBeneficeByDrinkType(numberOfTeaMade);
    }

    public int getNumberOfTeaMade() {
        return numberOfTeaMade;
    }
}