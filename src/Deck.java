import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<PlayingCard> deck = new Stack<>();

    // makes the deck
    public Deck(String cardType){
        try {
            for (int i = 1; i < 14; i++) {
                for (int j = 0; j < 4; j++) {
                    deck.add(new PlayingCard(i, j, cardType));
                }
            }
        }catch (InvalidCardValueException e){
            clearDeck();
            System.out.println("Exception " + e);
        }
        this.shuffle();
    }
    // makes the deck and shuffles it
    public Deck(String cardType, boolean shuffle) throws InvalidCardValueException {
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new PlayingCard(i, j, cardType));
            }
        }
        if (shuffle) {
            this.shuffle();
        }
    }
    // makes multiple decks in one stack
    public Deck(String cardType, boolean shuffle, int numberOfDecks) throws InvalidCardValueException {
        for (int k = 0; k < numberOfDecks; k++) {
            for (int i = 1; i < 14; i++) {
                for (int j = 0; j < 4; j++) {
                    deck.add(new PlayingCard(i, j, cardType));
                }
            }
        }
        if (shuffle) {
            this.shuffle();
        }
    }

    // returns the deck
    public Stack<PlayingCard> getDeck() {
        return this.deck;
    }

    // shuffles the deck
    public void shuffle(){
        Collections.shuffle(deck);
    }

    // sorts the deck from ace to king and spades, hearts, diamonds, clubs respectively
    public void sort(){
        deck.sort(PlayingCard::compareTo);
    }

    // returns a card taken from the top of the deck
    public PlayingCard drawCard(){
        return deck.pop();
    }

    // adds a card to the top of the deck
    public void addCard(PlayingCard c) {
        deck.add(c);
    }

    // empties the deck
    public void clearDeck() {
        deck.clear();
    }

    // merges the deck with an ArrayList of playing cards
    public void merge(ArrayList<PlayingCard> l) {
        deck.addAll(l);
    }

    // merges 2 decks
    public void merge(Deck d) {
        deck.addAll(d.getDeck());
    }

    public String toString(){
        return deck.toString();
    }

    // resets the deck and reshuffles it
    public void resetDeck(String cardType) {
        this.clearDeck();
        try {
            for (int i = 1; i < 14; i++) {
                for (int j = 0; j < 4; j++) {
                    deck.add(new PlayingCard(i, j, cardType));
                }
            }
        }catch (InvalidCardValueException e){
            clearDeck();
            System.out.println("Exception " + e);
        }
        this.shuffle();
    }
}
