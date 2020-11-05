import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

    private ArrayList<PlayingCard> hand = new ArrayList<>();
    private double bet;
    private boolean naturalBlackJack = false;
    private boolean bust = false;

    public Hand(){

    }

    public Hand(PlayingCard card){
        hand.add(card);
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
        int total = 0;
        for (PlayingCard card : hand){
            total += card.getCardValue();
        }

        for (PlayingCard card : hand){
            if (total + 10 <= 21){
                if (card.getCardValue() == 1){
                    total += 10;
                }
            } else {
                break;
            }
        }
        return total;
    }


    public double getBet() {
        return bet;
    }

    public ArrayList<PlayingCard> getArray(){
        return hand;
    }

    public boolean getNBJ(){return naturalBlackJack;}

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
        if((hand.size() ==2) && (hand.get(0).getCardValue()==hand.get(1).getCardValue())){
            return true;
        } else{
            return false;
        }
    }

    public boolean checkBust() {
        if (this.getTotal()>21){
            return true;
        }
        return false;
    }

    public void setNBJ(boolean b){
        naturalBlackJack = b;
    }

    public void setBet(double bet) {
        if (bet < 0) {
            throw new IllegalArgumentException("Bet can't be negative");
        } else {
            this.bet = bet;
        }
    }

    public void addBet(double bet) {
        if (bet < 0) {
            throw new IllegalArgumentException("Bet can't be negative");
        } else {
            this.bet += bet;
        }
    }

    public String toString(){
        return Arrays.toString(hand.toArray());
    }

    public void showAll() {
        for (PlayingCard card:hand) {
            card.setShow(true);
        }
    }

    public void setBust(boolean b) {
        bust = b;
    }

    public boolean getBust() {
        return bust;
    }
}
