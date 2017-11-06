package repository;

import model.DrinkType;

public class CoffeeReport implements Report {

    private int numberOfCoffeeMade;

    public void count() {
        numberOfCoffeeMade++;
    }

    public double calculateBenefice() {
        return DrinkType.COFFEE.calculateBenefice(numberOfCoffeeMade);
    }

    public int getNumberOfCoffeeMade() {
        return numberOfCoffeeMade;
    }
}