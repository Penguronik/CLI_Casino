/*
Author: Noam Borenstein
Date: Monday, November 9, 2020
Purpose: To create a slot machine and play the slot machine
 */

import java.util.Scanner;

public class SlotMachine {

    String[] results = new String[3];

    // constructor
    // creates the roll
    public SlotMachine() {
        String[] symbols = {"7", "诺姆", "♠", "$", "£", "♣", "♦", "❤", "€"};

        this.results[0] = symbols[(int) (Math.random()*(9))];
        this.results[1] = symbols[(int) (Math.random()*(9))];
        this.results[2] = symbols[(int) (Math.random()*(9))];
    }

    // returns the symbols rolled
    public String[] getResults() {
        return this.results;
    }

    // checks if the roll won
    public boolean winCheck() {
        return this.results[0].equals(this.results[1]) && this.results[0].equals(this.results[2]);
    }

    // checks if hanji should be played
    public boolean hanjiCheck() {
        return this.results[0].equals("诺姆") && this.results[1].equals("诺姆") && this.results[2].equals("诺姆");
    }

    // playing the slot machine
    public static void playSlots(User user) {

        System.out.println("Welcome to Noam's Slot-Mania!");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Scanner sc = new Scanner(System.in);

        String betStr;
        double bet = 0;
        boolean invalidBet;

        // getting the users bet
        do {
            System.out.println("How much would you like to bet? (enter Q to quit)");
            betStr = sc.nextLine();

            try {
                // see if slots should be quit
                if (betStr.toUpperCase().equals("Q")) {
                    return;
                }
                bet = Double.parseDouble(betStr);
                invalidBet = bet < 0 || bet > user.getBalance();
            } catch (NumberFormatException e) {
                invalidBet = true;
            }

            if (invalidBet) {
                System.out.println("That is an invalid bet!");
                System.out.println("Please try again!");
                System.out.println();
            }

        } while (invalidBet);

        System.out.println();

        System.out.println("You bet " + bet + "$");

        // setting the payout multiplier
        int multiplier;
        if (bet < 100) {
            multiplier = 4;
        }
        else if (bet < 1000) {
            multiplier = 5;
        }
        else if (bet < 5000) {
            multiplier = 8;
        }
        else if (bet < 12500) {
            multiplier = 10;
        }
        else {
            multiplier = 12;
        }

        // tell the user how much their bet will be multiplies by
        System.out.println("If you win, you will receive " + multiplier + "x your bet!");

        System.out.println();

        // initialize the SlotMachine
        SlotMachine sm  = new SlotMachine();

        System.out.println("You got:");

        // print the users roll
        for (int i = 0; i < sm.getResults().length; i++) {
            System.out.print(sm.getResults()[i] + " ");
        }

        System.out.println();
        System.out.println();

        // add winnings or subtract loss and tell the player if they won
        if (sm.winCheck()) {
            System.out.println("You win!");
            System.out.println("You won " + bet * multiplier + "$");
            System.out.println();
            user.setBalance(user.getBalance() + (bet*multiplier));
        }
        else {
            System.out.println("You lose!");
            System.out.println("You lost " + bet + "$");
            System.out.println();
            user.setBalance(user.getBalance() - bet);
        }

        if (sm.hanjiCheck()) {
            System.out.println("Ching Cheng Hanji");
            System.out.println();
        }

        String playAgain;

        do {
            System.out.println("Would you like to play again? Press Y for yes, N for no and BJ for blackjack!");
            playAgain = sc.nextLine();
            playAgain = playAgain.toUpperCase();
            System.out.println();
            switch (playAgain) {
                case "Y":
                    playSlots(user);
                    break;
                case "N":
                    System.out.println();
                    return;
                case "BJ":
                    Blackjack.playBlackjack(user);
                    break;
            }
        } while (!playAgain.equals("Y") && !playAgain.equals("BJ"));

        System.out.println();
    }
}
