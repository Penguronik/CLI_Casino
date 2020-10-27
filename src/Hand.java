public class Hand {

    public void addCard(PlayingCard card){
        //Add card to hand
    }

    public void drawCard(Deck deck){
        addCard(deck.drawCard());
        //Use addCard()
        //Draw one card from deck
    }

    public void drawCard(Deck deck, boolean show){
        addCard(deck.drawCard().setShow(show));
        //Use addCard()
        //Draw one card from deck
    }

    public int getTotal(){
        return 0;//Make this return the total of the list (Aces counted as 1)
    }

    public int getTotal(boolean checkAces){
        return 0;//Make this return the total of the list (Aces counted as 11
    }

    public boolean contains(PlayingCard card){
        return true; //Return true if the array contains the given card
    }
    public boolean contains(int v) {
        return true; //Return true if the array contains the given card,
        // if .equals or something doesn't work ask Noam about it
        // Also ask Noam to check if a number exists in a deck without being given the suit
    }
    public boolean contains(int v, int s) throws InvalidCardValueException {
        PlayingCard card = new PlayingCard(v, s);
        return true; //Return true if the array contains the given card, if .equals or something doesn't work ask Noam about it
    }

    public boolean lostCheck() {
        if (this.getTotal(true)>21){
            return true;
        }// Figure out a place where Ace is checked for and stuff math
        return false;
    }

}
