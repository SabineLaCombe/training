package repository;

import model.DrinkType;

public class OrangeJuiceReport implements Report{

    private int numberOfOrangeJuiceMade;

    public void count() {
        numberOfOrangeJuiceMade++;
    }

    public double calculateBenefice() {
        return DrinkType.ORANGE_JUICE.calculateBenefice(numberOfOrangeJuiceMade);
    }

    public int getNumberOfOrangeJuiceMade() {
        return numberOfOrangeJuiceMade;
    }
}