import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

    private ArrayList<PlayingCard> hand = new ArrayList<>();
    private double bet;

    public Hand(){

    }

    public Hand(PlayingCard card){
    }

    public void addCard(PlayingCard card) {
        hand.add(card);
    }

    public void removeCard(int index){
        hand.remove(index);
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
        return 0;//Make this return the total of the list
    }

    public double getBet() {
        return bet;
    }

    public ArrayList<PlayingCard> getArray(){
        return hand;
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

    public boolean splittable(){
        if((hand.size() == 2) && (hand.get(0).getCardValue()==hand.get(1).getCardValue())){
            return true;
        } else{
            return false;
        }
    }

    public boolean checkBust() {
        if (this.getTotal()>21){
            return true;
        }// Figure out a place where Ace is checked for and stuff math
        return false;
    }

    public void setBet(double bet) {
        if (bet < 0) {
            throw new IllegalArgumentException("Bet can't be negative");
        } else {
            this.bet = bet;
        }
    }

    public String toString(){
        return Arrays.toString(hand.toArray());
    }
}
