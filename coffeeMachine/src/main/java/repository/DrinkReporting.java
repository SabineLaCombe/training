package repository;

import model.DrinkType;

public interface DrinkReporting {
    void countDrinks(DrinkType drinkType);

    String getDrinkSoldReport();
}
