package repository;

import model.DrinkType;

public class CoffeeReport implements Report {

    private int numberOfCoffeeMade;

    public void count() {
        numberOfCoffeeMade++;
    }

    public double calculateBenefice() {
        return DrinkType.COFFEE.calculateBeneficeByDrinkType(numberOfCoffeeMade);
    }

    public int getNumberOfCoffeeMade() {
        return numberOfCoffeeMade;
    }
}