import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) throws InvalidCardValueException {
        Deck playingDeck = new Deck("bj");
        User user = new User(100);
        Dealer dealer = new Dealer();
        Scanner sc = new Scanner(System.in);
        boolean mainLoop = false, actionLoop = true, canSplit, canStand = true, canHit = true, canDouble, naturalBlackjack = false, bust = false, dealerBust = false;
        //ADD ERROR HANDLING IF INPUTS ARE NEVER TURNED INTO VISUAL
        //1
        mainLoop: do {
            /*Get user bet*/
            System.out.println("Your balance is: " + user.getBalance());
            System.out.print("Enter your bet: ");
            user.setBet(sc.nextDouble());
            sc.nextLine();//This line is here to fix the glitch with scanner

            //2
            //Make it show cards in hand to only the user who is seeing it. Creates opportunity for networking.
            //(You may need to understand networking to be able to do this so you can just show all user cards for now)
            user.drawCard(playingDeck, true);

            //3
            dealer.drawCard(playingDeck, true);

            //4
            user.drawCard(playingDeck, true);

            //5
            dealer.drawCard(playingDeck);

            System.out.println(user.getHand());
            System.out.println(dealer.getHand());

            //6
            if (user.getHand().getTotal() == 21) {
                naturalBlackjack = true;
            }

            //7 ADD BALANCE CHECK FOR DOUBLING
            for (int handNum = 0; handNum < user.getHands().size(); handNum++) {
                canSplit = (user.getHand(handNum).splittable()) && (user.getBalance() >= 2*user.getBet(handNum));
                canDouble = user.getBalance() >= 2*user.getBet(handNum);
                actionLoop: while (actionLoop) {
                    System.out.println("Pick one of: " + (canSplit ? "split, " : "") + (canDouble ? "double, " : "") + "stand, " + "hit");
                    switch (sc.nextLine()) {
                        case "split":
                            if (canSplit) {
                                user.split(handNum);
                                canDouble = false;
                                break;
                            }
                        case "stand":
                            break actionLoop;
                        case "hit":
                            user.drawCard(playingDeck, handNum, true);
                            canSplit = false;
                            canDouble = false;
                            break;
                        case "double":
                            if (canDouble) {
                                user.drawCard(playingDeck, handNum, true);
                                break actionLoop;
                            }
                        default:
                            System.out.println("Wrong input");

                    }//End of switch

                    if (user.checkBust(handNum)) {
                        bust = true;
                        break;
                    }
                    System.out.print("Dealer Cards: ");
                    System.out.println(dealer.getHand());
                    System.out.println();
                    System.out.print("Player Cards:");
                    System.out.println(user.getHand());
                }//End of actionLoop
            }//End of for loop
            if (naturalBlackjack){
                dealer.showAll();
                System.out.println("Natural Blackjack, You Won!");
            }else if(bust){
                dealer.showAll();
                System.out.println("You Busted!");
            }else{
                while (dealer.shouldHit()){
                    dealer.drawCard(playingDeck);
                    if(dealer.checkBust()){
                        System.out.println("Dealer Busted, You Won!");
                        dealerBust = true;
                    }
                }
                if (!dealerBust) {
                    if (dealer.getHand().getTotal() > user.getHand().getTotal()) {
                        System.out.println("You Lost!");
                    } else if (dealer.getHand().getTotal() < user.getHand().getTotal()) {
                        System.out.println("You Won!");
                    } else {
                        System.out.println("Tie!");
                    }
                }
            }


            /*Game flow
            1. Choose how much to bet
            2. 1 card to player
            3. Open card to dealer
            4. Another card to player
            5. Closed card to dealer
            6. Check natural blackjack
            7. Split(conditional)/Stand/Hit/Double #Make all of these conditional to turn them off when needed
                a. Split
                    1. If 2 cards of equal value (including 2 royalty). Split cap is 3 (4 separate hands)
                    2. Split into 2 hands and match bet for both
                    3. If split 2 aces, then only 1 card is allowed to be drawn for both (Only Stand/Hit(once)/Split(3 total)), if you get 21 it doesn't count as a natural blackjack
                    4. Back to 7. (Stand/Hit/Double/Split(3 total))
                b. Stand
                    1. Skip to 8
                c. Hit
                    1. Card to player
                    2. Check Bust and blackjack
                        if Bust: lose
                        else if Blackjack: win
                    3. Back to 7 (Only Stand/Hit)
                d. Double
                    1. Double player bet
                    2. Card to player
                    3. Check Bust and blackjack
                        if Bust: lose
                        else if Blackjack: win
            8. Show dealer card
            9. While dealer below 17, dealer hits
            10. Dealer cards calculated, check if bust
            11. else, dealer cards compared to player cards
                a. if dealer>player: lost
                b. else if player>dealer: win
                c. else: tie
            12. Cards disposed (held in a trash deck?)
             */
        }while(mainLoop);
    }
}
