/*
Author: Roni Kant, Tomer Lapid
        - Roni worked on the game-flow
        - Tomer created the win conditions
Date: Monday, November 9, 2020
Purpose: Combines all the classes and methods we made in order to play the full game of blackjack.
 */

import java.util.Scanner;

public class Blackjack {
    public static void playBlackjack(User user) {
        //Initializing variables
        Deck playingDeck = new Deck("bj");
        Dealer dealer = new Dealer();
        Scanner sc = new Scanner(System.in);
        boolean mainLoop, actionLoop = true, canSplit, canDouble, dealerBust = false, invalid;
        int handNum;
        String input;
        //Getting user inputs to initialize the game
        System.out.println("Welcome to Blackjack!");
        do{
            System.out.print("How many decks would you like to play with?: ");
            try {
                playingDeck = new Deck("bj", sc.nextInt());
                invalid = false;
            }catch (Exception e){
                System.out.println("Invalid input");
                invalid = true;
            }
            sc = new Scanner(System.in);
        }while(invalid);

        System.out.println("You are playing with " + playingDeck.getDeck().size() + " cards");

        //Main loop of the game
        do {
            //Initializing user and dealer's hands and setting the bet for the current game
            user.createHand();
            dealer.createHand();
            handNum = 0;
            System.out.println("Your balance is: " + user.getBalance());
            do{
                System.out.print("Enter your bet: ");
                try {
                    user.setBet(sc.nextDouble());
                    invalid = false;
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    invalid = true;
                }
                sc = new Scanner(System.in);
            }while(invalid);

            //Dealing initial cards to player and dealer, one of dealer's cards is set to not be visible to the player
            user.drawCard(playingDeck, true);
            dealer.drawCard(playingDeck, true);
            user.drawCard(playingDeck, true);
            dealer.drawCard(playingDeck);

            //Checking if player got a natural blackjack from the beginning (for 2.5x money)
            if (user.getHand().getTotal() == 21) {
                user.getHand(handNum).setNBJ(true);
            }

            //While loop that iterates through the player's hands (in case they split)
            //This is a while loop instead of a for loop as java has issues when you add to an array while you are iterating through it with a for loop
            do {
                System.out.println("\n" + "Dealer Cards: " + dealer.getHand());
                System.out.println("User Cards: " + user + "\n");
                //The loop that each hand goes through to decide and perform the user's actions
                actionLoop: while (actionLoop) {
                    //Ensures that the deck doesn't run out of cards
                    if (playingDeck.getDeck().size() < 20){
                        System.out.println("Few cards left in deck, resetting deck.");
                        playingDeck.resetDeck("bj");
                    }
                    System.out.println("You're On Hand #" + (handNum + 1));
                    //Decides if user is able to split or double
                    canSplit = (user.getHand(handNum).splittable()) && (user.getBalance() >= 2 * user.getBet(handNum));
                    canDouble = (user.getBalance() >= 2 * user.getBet(handNum)) && (user.getHand(handNum).getArray().size() == 2);
                    //Asks user for their action and performs it if the user has the option
                    System.out.println("Pick one of: " + (canSplit ? "split, " : "") + (canDouble ? "double, " : "") + "stand, " + "hit");
                    switch (sc.nextLine()) {
                        //Split action
                        case "split":
                            if (canSplit) {
                                user.split(handNum, playingDeck);
                                break;
                            }
                        //Stand action
                        case "stand":
                            break actionLoop;
                        //Hit action
                        case "hit":
                            user.drawCard(playingDeck, handNum, true);
                            break;
                        //Double action
                        case "double":
                            if (canDouble) {
                                user.drawCard(playingDeck, handNum, true);
                                user.addBet(user.getBet(handNum), handNum);
                                break actionLoop;
                            }
                        //It goes here if the user inputs a wrong input
                        default:
                            System.out.println("Wrong input");

                    }//End of switch

                    System.out.println("Dealer Cards: " + dealer.getHand());
                    System.out.println("Player Cards: " + user + "\n");

                    //Breaks out of loop if user busted
                    if (user.checkBust(handNum)) {
                        actionLoop = false;
                    }
                }//End of actionLoop

                user.getHand(handNum).setBust(user.checkBust(handNum));

                handNum++;
            } while (handNum < user.getHands().size()); //End of while loop

            handNum = 0;

            //While loop to iterate through each player hand and see if it wins or loses
            do {
                dealer.showAll();
                System.out.println("Dealer Cards: " + dealer.getHand());
                System.out.println("Player Cards: " + user + "\n");
                if (user.getHand(handNum).getNBJ()) {
                    System.out.println("Hand #" + (handNum + 1) + " Has Natural Blackjack, You Won!");
                    user.won(handNum, true);
                } else if (user.getHand(handNum).getBust()) {
                    System.out.println("Hand #" + (handNum + 1) + " Busted!");
                    user.lost(handNum);
                } else {
                    //Draws cards for dealer until dealer has minimum of 17
                    while (dealer.shouldHit()) {
                        dealer.drawCard(playingDeck, true);
                        System.out.println("Dealer Cards: " + dealer.getHand());
                        System.out.println("Player Cards: " + user + "\n");
                        if (dealer.checkBust()) {
                            System.out.println("Dealer Busted, Hand #" + (handNum + 1) + " Won!");
                            dealerBust = true;
                            user.won(handNum);
                        }
                    }
                    //Win and loss checks
                    if (!dealerBust) {
                        if (dealer.getHand().getTotal() > user.getHand(handNum).getTotal()) {
                            System.out.println("Hand #" + (handNum + 1) + " Lost!");
                            user.lost(handNum);
                        } else if (dealer.getHand().getTotal() < user.getHand(handNum).getTotal()) {
                            System.out.println("Hand #" + (handNum + 1) + " Won!");
                            user.won(handNum);
                        } else {
                            System.out.println("Hand #" + (handNum + 1) + " Tied!");
                            user.tie(handNum);
                        }
                    }
                }
                user.getHand(handNum).setNBJ(false);
                user.getHand(handNum).setBust(false);
                handNum++;
            } while (handNum < user.getHands().size()); //End of while loop
            //Clearing user and dealer hands
            user.clearHands();
            dealer.clearHands();
            dealerBust = false;
            //Outputting results and asking user what they want to do next
            System.out.println("Your final balance is: " + user.getBalance());
            System.out.print("Type \"Q\" to quit, slots to go to the Slot Machine, and anything else to keep playing: ");
            input = sc.nextLine().toUpperCase();
            mainLoop = !input.equals("Q");
            if (input.equals("SLOTS")) {
                SlotMachine.playSlots(user);
            }
        } while (mainLoop); //End of mainLoop
    }
}
