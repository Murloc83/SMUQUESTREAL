package ClassVersion;

public class Place {
    private String name;
    private String activity;
    private int value;
//sets the values of name, activity and value
    public Place(String name, String activity, int value) {
        this.name = name;
        this.activity = activity;
        this.value = value;
    }
    //getters and setters for each of the three attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
// prints a description of the place instance
    @Override
    public String toString() {
        return name + " - " + activity + " (Value: " + value + ")";
    }
}

