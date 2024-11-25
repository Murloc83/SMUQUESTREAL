package ClassVersion;

import java.util.Scanner;
//launches game and gathers user input
public class Launcher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SMUQuestClassVersion game = new SMUQuestClassVersion();
        // prompts for winningAmount and sends to the game
        System.out.print("How much is needed to win? $ ");
        int amt = input.nextInt();
        game.setWinningAmount(amt);

        // prompts for total # of players
        System.out.print("How many players? ");
        int playerCount = input.nextInt();

        // creates players
        for (int x = 1; x <= playerCount; x++) {
            System.out.printf("Player #%d name: ", x);
            String name = input.next();
            game.addPlayer(name);
        }
        game.playGame();
    }
}
