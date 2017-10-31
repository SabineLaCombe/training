public class DrinkReport {

    private int numberOfCoffeeMade;

    void countDrinkMade() {
        numberOfCoffeeMade ++;
    }

    String getDrinkMadeReport() {
        return Integer.toString(numberOfCoffeeMade)+" coffee made during the day";
    }
}
