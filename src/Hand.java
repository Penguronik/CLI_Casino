public class Hand {

    public void addCard(PlayingCard card){
        //Add card to hand
    }
    public void addCard(PlayingCard[] card){
        //Add array of cards to hand
        //**This one is more optional**
    }

    public void drawCard(Deck deck){
        //Use addCard()
        //Draw one card from deck
    }
    public void drawCard(Deck deck, int amount){
        //Use the second addCard()
        //Draw specified amount of cards from deck
    }
}
