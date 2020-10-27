public class Main {
    public static void main(String[] args) throws InvalidCardValueException {
        Deck playingDeck = new Deck();
        User user = new User(100);

        /*Game flow
        1. Choose how much to bet
        2. 1 card to player
        3. Open card to dealer
        4. Another card to player
        5. Closed card to dealer
        6. Split/Stand/Hit/Double
            a. Split
                1.
            b. Stand
                1. Skip to 7
        7. Show dealer card
        8. While dealer below 17, dealer hits
        9. Dealer cards calculated, check if bust
        10. else, dealer cards compared to player cards
            a. if dealer>player lost
            b. if player>dealer win

         */
    }
}
