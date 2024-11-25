package ClassVersion;
import java.util.ArrayList;
public class SMUQuestClassVersion {

    //- creates instances of die and campus and store them in attributes theDie and theCampus
    //- creates players ArrayList, initializes winningAmount to 0, gets and sets winningAmount
    private int winningAmount;
    private ArrayList<Player> players;
    private Die theDie;
    private Campus theCampus;

    public SMUQuestClassVersion() {
        this.winningAmount = 0;
        this.players = new ArrayList<>();
        this.theDie = new Die();
        this.theCampus = new Campus();
    }
    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }
//  uses the value of the String passed in as a parameter to instantiate a new player.
//  gets the Place instance of the starting location of the game by sending the getFirstPlace message to the Campus.
//  includes that Place instance as a parameter of the player’s constructor.
//  after creating the Player, adds that Player object to the players ArrayList
    public void addPlayer(String name) {
        Place startingPlace = theCampus.getFirstPlace();
        Player player = new Player(name, 500, startingPlace);
        players.add(player);
    }
// creates a loop – one that continues perpetually until a player wins the game,
// and another loop each player in the players ArrayList takes a turn.
// after each turn, checks to see if the player attained the winningAmount and breaks if true.
    public void playGame() {
        boolean winnerBoolean = false;

        while (!winnerBoolean) {
            for (Player player : players) {
                player.takeTurn(theCampus, theDie);
                if (player.getMoney() >= winningAmount) {
                    System.out.println("GAME OVER..." + player.getName() + " is the winner!!");
                    winnerBoolean = true;
                    break;
                }
            }
        }
    }
}
