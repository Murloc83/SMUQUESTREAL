package ClassVersion;
import java.util.Random;
public class Die {
    private int value;

    public Die() {
        roll();
    }

    public int roll() {
        Random random = new Random();
        this.value = random.nextInt(6) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Die shows: " + value;
    }
}