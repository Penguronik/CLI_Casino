import java.util.ArrayList;

public class Player {

    ArrayList<Hand> hands = new ArrayList<>(); //No reason for this to be private as hand already has the restrictions from the Hand class

    //constructor 1
    public Player(){
        //This is what is run when it is extended

    }

    //getters

    public ArrayList<Hand> getHand(){
        return this.hands;
    }

    //setters

    public void setHand(Hand hand, int handNum){
        this.hands.set(handNum, hand);
    }

    public void addHand(Hand hand){
        this.hands.add(hand);
    }

    //drawCard

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
    public void drawCard(Deck deck, boolean show, int handNum){
        hands.get(handNum).drawCard(deck,show);
        //Draw a card from the deck
    }
}
