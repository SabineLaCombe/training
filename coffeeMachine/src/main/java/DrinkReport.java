import java.text.MessageFormat;

public class DrinkReport {

    private int numberOfCoffeeMade;
    private int numberOfTeaMade;

    void countDrinkMade(DrinkType drinkType) {
        if(DrinkType.COFFEE.equals(drinkType))
            numberOfCoffeeMade ++;
        if(DrinkType.TEA.equals(drinkType))
            numberOfTeaMade ++;
    }

    String getDrinkMadeReport() {
        return MessageFormat.format("{0} coffee made\n {1} tea made\n", numberOfCoffeeMade, numberOfTeaMade);
    }
}
