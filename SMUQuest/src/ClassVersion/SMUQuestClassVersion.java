package ClassVersion;
import java.util.ArrayList;
public class SMUQuestClassVersion {
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

    public void addPlayer(String name) {
        Place startingPlace = theCampus.getFirstPlace();
        Player player = new Player(name, 0, startingPlace);
        players.add(player);
    }

    public void playGame() {
        boolean winnerFound = false;

        while (!winnerFound) {
            for (Player player : players) {
                player.takeTurn(theCampus, theDie);
                if (player.getMoney() >= winningAmount) {
                    System.out.println(player.getName() + " has won the game!");
                    winnerFound = true;
                    break;
                }
            }
        }
    }
}
