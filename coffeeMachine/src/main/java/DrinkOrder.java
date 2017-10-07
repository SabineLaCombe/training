
public class DrinkOrder {

    private DrinkType drinkType;

    public DrinkOrder(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String createMessageToDrinkMaker() {
        if(this.drinkType.equals(DrinkType.COFFEE)) {
            return "Drink maker makes one coffee";
        } else if(this.drinkType.equals(DrinkType.TEA)) {
            return "Drink maker makes one tea";
        }
        return null;
    }
}
