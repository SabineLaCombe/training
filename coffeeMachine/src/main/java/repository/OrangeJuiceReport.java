package repository;

import model.DrinkType;

public class OrangeJuiceReport implements Report{

    int numberOfOrangeJuiceMade;

    public void count() {
        numberOfOrangeJuiceMade++;
    }

    public double calculateBenefice() {
        return DrinkType.ORANGE_JUICE.calculateBenefice(numberOfOrangeJuiceMade);
    }
}