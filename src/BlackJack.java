import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) throws InvalidCardValueException {
        Deck playingDeck = new Deck("bj");
        User user = new User(100);
        Dealer dealer = new Dealer();
        Scanner sc = new Scanner(System.in);
        boolean mainLoop, actionLoop = true, canSplit, canDouble, dealerBust = false;
        int handNum;
        //ADD ERROR HANDLING IF INPUTS ARE NEVER TURNED INTO VISUAL
        //1
        do {
            user.createHand();
            dealer.createHand();
            handNum = 0;
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

            //6
            if (user.getHand().getTotal() == 21) {
                user.getHand(handNum).setNBJ(true);
            }

            //7
            do {
                System.out.println("\n" + "Dealer Cards: " + dealer.getHand());
                System.out.println("User Cards: " + user + "\n");
                actionLoop:
                while (actionLoop) {
                    System.out.println("You're On Hand #" + handNum);
                    canSplit = (user.getHand(handNum).splittable()) && (user.getBalance() >= 2 * user.getBet(handNum));
                    canDouble = (user.getBalance() >= 2 * user.getBet(handNum)) && (user.getHand(handNum).getArray().size() == 2);
                    System.out.println("Pick one of: " + (canSplit ? "split, " : "") + (canDouble ? "double, " : "") + "stand, " + "hit");
                    switch (sc.nextLine()) {
                        case "split":
                            if (canSplit) {
                                user.split(handNum, playingDeck);
                                break;
                            }
                        case "stand":
                            break actionLoop;
                        case "hit":
                            user.drawCard(playingDeck, handNum, true);
                            break;
                        case "double":
                            if (canDouble) {
                                user.drawCard(playingDeck, handNum, true);
                                user.addBet(user.getBet(handNum), handNum);
                                break actionLoop;
                            }
                        default:
                            System.out.println("Wrong input");

                    }//End of switch

                    System.out.println("Dealer Cards: " + dealer.getHand());
                    System.out.println("Player Cards: " + user + "\n");

                    if (user.checkBust(handNum)) {
                        break;
                    }
                }//End of actionLoop

                user.getHand(handNum).setBust(user.checkBust(handNum));

                handNum++;
            } while (handNum < user.getHands().size());

            handNum = 0;

            do {
                dealer.showAll();
                System.out.println("Dealer Cards: " + dealer.getHand());
                System.out.println("Player Cards: " + user + "\n");
                if (user.getHand(handNum).getNBJ()) {
                    System.out.println("Hand #" + handNum + 1 + " Has Natural Blackjack, You Won!");
                    user.won(handNum, true);
                } else if (user.getHand(handNum).getBust()) {
                    System.out.println("Hand #" + handNum + 1 + " Busted!");
                    user.lost(handNum);
                } else {
                    while (dealer.shouldHit()) {
                        dealer.drawCard(playingDeck, true);
                        System.out.println("Dealer Cards: " + dealer.getHand());
                        System.out.println("Player Cards: " + user + "\n");
                        if (dealer.checkBust()) {
                            System.out.println("Dealer Busted, Hand #" + handNum + 1 + " Won!");
                            dealerBust = true;
                            user.won(handNum);
                        }
                    }
                    if (!dealerBust) {
                        if (dealer.getHand().getTotal() > user.getHand(handNum).getTotal()) {
                            System.out.println("Hand #" + handNum + 1 + " Lost!");
                            user.lost(handNum);
                        } else if (dealer.getHand().getTotal() < user.getHand(handNum).getTotal()) {
                            System.out.println("Hand #" + handNum + 1 + " Won!");
                            user.won(handNum);
                        } else {
                            System.out.println("Hand #" + handNum + 1 + " Tied!");
                            user.tie(handNum);
                        }
                    }
                }
                user.getHand(handNum).setNBJ(false);
                user.getHand(handNum).setBust(false);
                handNum++;
            } while (handNum < user.getHands().size());
            user.clearHands();
            dealer.clearHands();
            dealerBust = false;
            System.out.println("Your final balance is: " + user.getBalance());
            System.out.print("Type \"Q\" to quit and anything else to keep playing: ");
            mainLoop = !sc.nextLine().equals("Q");
        } while (mainLoop);
    }
}
