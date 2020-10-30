import java.util.ArrayList;

public class Hand {

    private ArrayList<PlayingCard> hand = new ArrayList<>();

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

    public boolean contains(int v) {
        for (PlayingCard card: hand){
            if(card.getCardValue() == v){
                return true;
            }
        }
        return false;
    }
    public boolean contains(int v, int s) {
        for (PlayingCard card: hand){
            if((card.getCardValue() == v) && (card.getSuitValue() == s)){
                return true;
            }
        }
        return false;
    }

    public boolean checkBust() {
        if (this.getTotal(true)>21){
            return true;
        }// Figure out a place where Ace is checked for and stuff math
        return false;
    }

}
