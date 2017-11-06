package repository;

import model.DrinkType;

public class CoffeeReport implements Report {

    int numberOfCoffeeMade;

    public void count() {
        numberOfCoffeeMade++;
    }

    public double calculateBenefice() {
        return DrinkType.COFFEE.calculateBenefice(numberOfCoffeeMade);
    }
}