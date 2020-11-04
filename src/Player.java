import java.util.ArrayList;

public class Player {

    private ArrayList<Hand> hands = new ArrayList<>(); //No reason for this to be private as hand already has the restrictions from the Hand class

    //constructor 1
    public Player(){
    }

    //getters
    public void createHand(){
        hands.add(new Hand());
    }

    public Hand getHand(){
        return this.hands.get(0);
    }

    public Hand getHand(int handNum){
        return this.hands.get(handNum);
    }

    public ArrayList<Hand> getHands(){return this.hands;}

    //setters

    public void setHand(Hand hand){
        this.hands.set(0, hand);
    }

    public void setHand(Hand hand, int handNum){
        this.hands.set(handNum, hand);
    }

    public void addHand(Hand hand){
        this.hands.add(hand);
    }

    public void clearHands(){
        this.hands.clear();
    }

    public void clearHand(int handNum){
        this.hands.remove(handNum);
    }

    //

    public void drawCard(Deck deck){
        hands.get(0).drawCard(deck);
        //Draw a card from the deck
    }
    public void drawCard(Deck deck, int handNum){
        hands.get(handNum).drawCard(deck);
        //Draw a card from the deck
    }

    public void drawCard(Deck deck, boolean show){
        hands.get(0).drawCard(deck,show);
        //Draw a card from the deck
    }
    public void drawCard(Deck deck, int handNum, boolean show){
        hands.get(handNum).drawCard(deck,show);
        //Draw a card from the deck
    }

    public boolean checkBust(){
        return getHand().checkBust();
    }

    public boolean checkBust(int handNum){
        return getHand(handNum).checkBust();
    }

    public void showAll(){
        for(Hand i: getHands()){
            i.showAll();
        }
    }
}
