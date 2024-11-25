package ClassVersion;
// sets the values of name, money and location using the three values passed in as parameters
public class Player {
    private String name;
    private int money;
    private Place place;

    public Player(String name, int money, Place place) {
        this.name = name;
        this.money = money;
        this.place = place;
    }
    // getters and setters for the attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //string representation of the Player including values of name, money and location
    @Override
    public String toString() {
        return name + " stopped at " + place.getName() + " " + place.getActivity() +  " and now has $" + money;
    }
// adds the value passed in to the player’s money value.
public void updateMoney(int amount) {
        this.money += amount;
}
// sends the roll message to the Die to get a roll value, sends the getNextPlace message to the Campus including these two parameters:
// the Place instance that is the player’s current location, and the roll value returned from the Die
// sets the Player’s location to this new Place instance.
    public void takeTurn(Campus campus, Die die) {
        int roll = die.roll();
        Place newPlace = campus.getNextPlace(place, roll);
        place = newPlace;
        updateMoney(place.getValue());
        System.out.println(this);
    }

}