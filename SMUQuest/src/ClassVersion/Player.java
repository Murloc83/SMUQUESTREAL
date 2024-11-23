package ClassVersion;

public class Player {
    private String name;
    private int money;
    private Place place;

    public Player(String name, int money, Place place) {
        this.name = name;
        this.money = money;
        this.place = place;
    }

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

    public void updateMoney(int amount) {
        this.money += amount;
    }

    public void takeTurn(Campus campus, Die die) {
        int roll = die.roll();
        Place newPlace = campus.getNextPlace(place, roll);
        place = newPlace;
        updateMoney(place.getValue());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return name + " is at " + place.getName() + " (" + place.getActivity() + ") with $" + money;
    }
}