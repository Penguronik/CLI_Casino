public class Hand {

    public void addCard(PlayingCard card){
        //Add card to hand
    }

    public void drawCard(Deck deck){
        addCard(deck.drawCard());
        //Use addCard()
        //Draw one card from deck
    }
}
