import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) throws InvalidCardValueException {
        Deck playingDeck = new Deck("bj");
        User user = new User(100);
        Dealer dealer = new Dealer();
        Scanner sc = new Scanner(System.in);
        boolean mainLoop = true, actionLoop = true, canSplit, canStand = true, canHit = true, canDouble, naturalBlackjack = false, bust = false, dealerBust = false;
        //ADD ERROR HANDLING IF INPUTS ARE NEVER TURNED INTO VISUAL
        //1
        mainLoop: do {
            user.createHand();
            dealer.createHand();
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

            System.out.println("Dealer Cards: " + dealer.getHand());
            System.out.println("User Cards: " + user.getHand());

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
                                user.split(handNum, playingDeck);
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
                                user.setBet(user.getBet(handNum), handNum);
                                break actionLoop;
                            }
                        default:
                            System.out.println("Wrong input");

                    }//End of switch

                    System.out.println("Dealer Cards: " + dealer.getHand());
                    System.out.println("Player Cards: " + user.getHand());

                    if (user.checkBust(handNum)) {
                        bust = true;
                        break;
                    }
                }//End of actionLoop

                dealer.showAll();
                System.out.println("Dealer Cards: " + dealer.getHand());
                System.out.println("Player Cards: " + user.getHand());
                if (naturalBlackjack){
                    System.out.println("Natural Blackjack, You Won!");
                    user.won(handNum, true);
                }else if(bust){
                    System.out.println("You Busted!");
                    user.lost(handNum);
                }else{
                    while (dealer.shouldHit()){
                        dealer.drawCard(playingDeck, true);
                        System.out.println("Dealer Cards: " + dealer.getHand());
                        System.out.println("Player Cards: " + user.getHand() + "\n");
                        if(dealer.checkBust()){
                            System.out.println("Dealer Busted, You Won!");
                            dealerBust = true;
                            user.won(handNum);
                        }
                    }
                    if (!dealerBust) {
                        if (dealer.getHand().getTotal() > user.getHand().getTotal()) {
                            System.out.println("You Lost!");
                            user.lost(handNum);
                        } else if (dealer.getHand().getTotal() < user.getHand().getTotal()) {
                            System.out.println("You Won!");
                            user.won(handNum);
                        } else {
                            System.out.println("Tie!");
                            user.tie(handNum);
                        }
                    }
                }
            }//End of for loop
            user.clearHands();
            dealer.clearHands();
            System.out.println("Your final balance is: " + user.getBalance());
            System.out.print("Type \"Q\" to quit and anything else to keep playing: ");
            mainLoop = !sc.nextLine().equals("Q");
        }while(mainLoop);
    }
}
