
public class DrinkOrder {

    private DrinkType drinkType;

    public DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String createMessageToDrinkMaker() {
        if(DrinkType.COFFEE.equals(this.drinkType)) {
            return "Drink maker makes one"+this.drinkType;
        } else if(DrinkType.TEA.equals(this.drinkType)) {
            return "Drink maker makes one tea";
        }
        return null;
    }
}
