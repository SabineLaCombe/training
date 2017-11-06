import model.DrinkType;

public interface EmailNotifier {

    void notifyMissingDrink(DrinkType drinkType);

}
