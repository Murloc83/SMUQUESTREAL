package MethodVersion;

import java.util.Random;
import java.util.Scanner;

public class SMUQuest {

    public static void main(String[] args) {
        // Locations and their descriptions
        String[] locations = {
                "admire the campus view at Bishop Boulevard",
                "visit the chapel at Perkins Theology School",
                "attend a concert at Meadows",
                "cheer for the soccer team at Westcott Field",
                "take a class at Cox School of Business",
                "watch a show at McFarlin Auditorium",
                "study at Dedman Law Library",
                "see the downtown skyline at Dallas Hall",
                "do an experiment at Fondren Science",
                "take a class at Simmons",
                "get a snack at Hughes-Trigg Student Center",
                "learn Java programming at Lyle",
                "watch a basketball game at Moody",
                "take a nap at Residential Commons",
                "cheer for Mustang football at Ford Stadium"
        };

        int[] moneyValues = {0, 200, -100, -100, 200, -100, 200, 0, 200, 200, -100, 200, -100, 0, -100};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to MethodVersion.SMUQuest!");

        // Get player names
        System.out.print("Player 1 name: ");
        String player1 = scanner.nextLine();
        System.out.println(player1 + " has $500");

        System.out.print("Player 2 name: ");
        String player2 = scanner.nextLine();
        System.out.println(player2 + " has $500");

        // Get winning amount
        System.out.print("How much is needed to win? ");
        int winningAmount = scanner.nextInt();

        // Initialize game state
        int money1 = 500, money2 = 500;
        int location1 = 0, location2 = 0;

        while (money1 < winningAmount && money2 < winningAmount) {
            // Player 1's turn
            int roll1 = rollDie(random);
            location1 = getDestination(location1, roll1);
            int delta1 = getMoneyAmount(moneyValues, location1, roll1);
            money1 += delta1;
            System.out.printf("%s rolled %d and stopped to %s.\n", player1, roll1, locations[location1]);
            System.out.printf("%s %s $%d and now has $%d\n", player1,
                    (delta1 >= 0 ? "collected" : "lost"), Math.abs(delta1), money1);

            if (money1 >= winningAmount) break;

            // Player 2's turn
            int roll2 = rollDie(random);
            location2 = getDestination(location2, roll2);
            int delta2 = getMoneyAmount(moneyValues, location2, roll2);
            money2 += delta2;
            System.out.printf("%s rolled %d and stopped to %s.\n", player2, roll2, locations[location2]);
            System.out.printf("%s %s $%d and now has $%d\n", player2,
                    (delta2 >= 0 ? "collected" : "lost"), Math.abs(delta2), money2);
        }

        // Announce winner
        if (money1 >= winningAmount) {
            System.out.printf("%s wins with $%d!\n", player1, money1);
        } else {
            System.out.printf("%s wins with $%d!\n", player2, money2);
        }
    }

    // Simulate rolling a die
    public static int rollDie(Random random) {
        return random.nextInt(6) + 1; // 1 to 6
    }

    // Get the new location based on the roll
    public static int getDestination(int currentSpace, int roll) {
        return (currentSpace + roll) % 15;
    }

    // Calculate the money adjustment
    public static int getMoneyAmount(int[] moneyValues, int location, int roll) {
        int baseValue = moneyValues[location];
        if (baseValue == 0) {
            // Special case: calculate based on roll
            return (roll % 2 == 0) ? 10 * roll : -10 * roll;
        }
        return baseValue;
    }
}

