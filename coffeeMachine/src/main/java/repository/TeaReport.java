package repository;

import model.DrinkType;

public class TeaReport implements Report {

    private int numberOfTeaMade;

    public void count() {
        numberOfTeaMade++;
    }

    public double calculateBenefice() {
        return DrinkType.TEA.calculateBenefice(numberOfTeaMade);
    }

    public int getNumberOfTeaMade() {
        return numberOfTeaMade;
    }
}