/*
Author:
Date: Monday, November 9, 2020
Purpose:
 */

import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        //Initializing variables
        boolean invalid;
        String gamemode;
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Casino Simulator by Noam Borenstein, Roni Kant, and Tomer Lapid");
        //Gets user balance
        do {
            System.out.print("Please enter the balance you'd like to start with: ");
            try {
                user.setBalance(sc.nextDouble());
                invalid = false;
            } catch (Exception e) {
                System.out.println("Invalid input");
                invalid = true;
            }
            sc = new Scanner(System.in);
        }while(invalid);

        System.out.println("You will be starting with a balance of: " + user.getBalance() + "\nWhat would you like to play?");
        //Sends user to game they want to play
        do {
            System.out.print("Enter 'bj' for Blackjack and 'slots' for the Slot Machine: ");
            gamemode = sc.nextLine();
            if (gamemode.equals("bj")) {
                Blackjack.playBlackjack(user);
                invalid = false;
            } else if (gamemode.equals("slots")) {
                SlotMachine.playSlots(user);
                invalid = false;
            } else {
                System.out.println("Invalid input");
                invalid = true;
            }
        }while(invalid);
    }
}
