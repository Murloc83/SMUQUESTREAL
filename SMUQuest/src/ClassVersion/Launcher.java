package ClassVersion;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create new game
        SMUQuestClassVersion game = new SMUQuestClassVersion();

        // Prompt for winning amount
        System.out.print("How much is needed to win? $ ");
        int amt = input.nextInt();
        game.setWinningAmount(amt);

        // Prompt for total number of players
        System.out.print("How many players? ");
        int playerCount = input.nextInt();

        // Create players
        for (int x = 1; x <= playerCount; x++) {
            System.out.printf("Player #%d name: ", x);
            String name = input.next();
            game.addPlayer(name);
        }

        // Start the game
        game.playGame();
    }
}
