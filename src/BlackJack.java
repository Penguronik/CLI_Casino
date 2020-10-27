import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) throws InvalidCardValueException {
        Deck playingDeck = new Deck();
        User user = new User(100);
        Dealer dealer = new Dealer();
        Scanner sc = new Scanner(System.in);
        double bet;
        int handNum = 0; //Make it iterate through the hands when there is more than 1 (potentially add all hands to an array that it picks them out of 1 by 1)
        //ADD ERROR HANDLING IF INPUTS ARE NEVER TURNED INTO VISUAL
        //1
        /*Get user bet*/bet = sc.nextDouble();
        user.setBet(bet);

        //2
        //Make it show cards in hand to only the user who is seeing it. Creates opportunity for networking.
        //(You may need to understand networking to be able to do this so you can just show all user cards for now)
        user.drawCard(playingDeck);

        //3
        dealer.drawCard(playingDeck, true);

        //4
        user.drawCard(playingDeck);

        //5
        dealer.drawCard(playingDeck);

        //6
        if (user.getHand(handNum).getTotal() == 21){
            //win
        }

        //7


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
    }
}
