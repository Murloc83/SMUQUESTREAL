package MethodVersion;

import java.util.Random;
import java.util.Scanner;

public class SMUQuest {

    public static void main(String[] args) {
        // creates an array for all the locations
        String[] places = {
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
//creates an array for the moneyValues corresponding to each case
        int[] moneyValues = {0, 200, -100, -100, 200, -100, 200, 0, 200, 200, -100, 200, -100, 0, -100};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        //outputs and asks for input on how much is needed to win SMUQuest
        System.out.println("Welcome to SMUQuest!");
        System.out.print("Player 1 name: ");
        String player1 = scanner.nextLine();
        System.out.println(player1 + " has $500");
        System.out.print("Player 2 name: ");
        String player2 = scanner.nextLine();
        System.out.println(player2 + " has $500");
        System.out.print("How much is needed to win? ");
        int winningAmount = scanner.nextInt();

        // initilializes money and location ints for each player
        int moneyPlayerOne = 500, moneyPlayerTwo = 500;
        int locationPlayerOne = 0, locationPlayerTwo = 0;

        while (moneyPlayerOne < winningAmount && moneyPlayerTwo < winningAmount) {
            // player ones roll
            int rollPlayerOne = rollDie(random);
            //calls get destination method
            locationPlayerOne = getDestination(locationPlayerOne, rollPlayerOne);
// creates a changeInMoneyPlayerOne variable, calls getMoney Amount, and updates player value accordingly
            int changeInMoneyPlayerOne = getMoneyAmount(moneyValues, locationPlayerOne, rollPlayerOne);
            moneyPlayerOne += changeInMoneyPlayerOne;
            //outputs to user and potrays collected and lost amounts
            System.out.printf("%s rolled %d and stopped to %s.\n", player1, rollPlayerOne, places[locationPlayerOne]);
            String action;
            if (changeInMoneyPlayerOne >= 0) {
                action = "collected";
            } else {
                action = "lost";
            }
            System.out.printf("     %s %s $%d and now has $%d\n", player1, action, Math.abs(changeInMoneyPlayerOne), moneyPlayerOne);

//breaks loop if playerone won
            if (moneyPlayerOne >= winningAmount) break;

            // same thing for player two
            int rollPlayerTwo = rollDie(random);
            locationPlayerTwo = getDestination(locationPlayerTwo, rollPlayerTwo);
            int changeInMoneyPlayerTwo = getMoneyAmount(moneyValues, locationPlayerTwo, rollPlayerTwo);
            moneyPlayerTwo += changeInMoneyPlayerTwo;
            System.out.printf("%s rolled %d and stopped to %s.\n", player2, rollPlayerTwo, places[locationPlayerTwo]);
            String actionTwo;
            if (changeInMoneyPlayerTwo >= 0) {
                actionTwo = "collected";
            } else {
                actionTwo = "lost";
            }

            System.out.printf("     %s %s $%d and now has $%d\n", player2, actionTwo, Math.abs(changeInMoneyPlayerTwo), moneyPlayerTwo);
        }

        // if statement to declare winner
        if (moneyPlayerOne >= winningAmount) {
            System.out.printf("%s won!      GAME OVER...\n", player1);
        } else {
            System.out.printf("%s won!      GAME OVER...\n", player2);
        }
    }

    // rolls a die
    public static int rollDie(Random random) {
        return random.nextInt(6) + 1; // 1 to 6
    }

    // gets a location based on die roll
    public static int getDestination(int currentSpace, int roll) {
        return (currentSpace + roll) % 15;
    }

    // calculates money amount
    public static int getMoneyAmount(int[] moneyValues, int location, int roll) {
        int baseValue = moneyValues[location];
        if (baseValue == 0) {
            // calculates based on roll
            if (roll % 2 == 0) {
                return 10 * roll;
            } else {
                return -10 * roll;
            }
        }
        return baseValue;
    }
}

