public class BlackJack {
    public static void main(String[] args) throws InvalidCardValueException {
        Deck playingDeck = new Deck();
        User user = new User(100);

        /*Game flow
        1. Choose how much to bet
        2. 1 card to player
        3. Open card to dealer
        4. Another card to player
        5. Closed card to dealer
        5.5 Check Bust and blackjack (natural blackjack only on first go)
            a. if bust: lose
            b. else if natural blackjack: win
            c. else if normal blackjack: skip to 7.
        6. Split(conditional)/Stand/Hit/Double #Make all of these conditional to turn them off when needed
            a. Split
                1. If 2 cards of equal value (including 2 royalty). Split cap is 3 (4 separate hands)
                2. Split into 2 hands and match bet for both
                3. If split 2 aces, then only 1 card is allowed to be drawn for both (Only Stand/Hit(once)/Split(3 total)), if you get 21 it doesn't count as a natural blackjack
                4. Back to 5. (Stand/Hit/Double/Split(3 total))
            b. Stand
                1. Skip to 7
            c. Hit
                1. Card to player
                2. Back to 5. (Only Stand/Hit)
            d. Double
                1. Double player bet
                2. Card to player
                3. Skip to 7
        6.5 Check Bust
        7. Show dealer card
        8. While dealer below 17, dealer hits
        9. Dealer cards calculated, check if bust
        10. else, dealer cards compared to player cards
            a. if dealer>player: lost
            b. else if player>dealer: win
            c. else: tie
        11. Cards disposed (held in a trash deck?)
         */
    }
}
