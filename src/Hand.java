public class Hand {

    public void addCard(PlayingCard card){
        //Add card to hand
    }

    public void drawCard(Deck deck){
        addCard(deck.drawCard());
        //Use addCard()
        //Draw one card from deck
    }

    public int getTotal(){
        return 0;//Make this return the total of the list (Aces counted as 11
    }

    public boolean contains(PlayingCard card){
        return true; //Return true if the array contains the given card
    }
    public boolean contains(int v) {
        return true; //Return true if the array contains the given card,
        // if .equals or smthng doesnt work ask Noam about it
        // Also ask Noam to check if a number exists in a deck without being given the suit
    }
    public boolean contains(int v, int s) throws InvalidCardValueException {
        PlayingCard card = new PlayingCard(v, s);
        return true; //Return true if the array contains the given card, if .equals or smthng doesnt work ask Noam about it
    }

}
