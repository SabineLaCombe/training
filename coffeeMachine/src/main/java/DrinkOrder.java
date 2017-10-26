
public class DrinkOrder {

    private DrinkType drinkType;

    public DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String createMessageToDrinkMaker() {
        if(DrinkType.COFFEE.equals(drinkType)) {
            return "Drink maker makes one "+drinkType.getDrinkLabel();
        } else if(DrinkType.TEA.equals(this.drinkType)) {
            return "Drink maker makes one tea";
        }
        return null;
    }
}
