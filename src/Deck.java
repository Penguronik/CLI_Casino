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
    public Deck(String cardType, boolean shuffle) {
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
        if (shuffle) {
            this.shuffle();
        }
    }

    public Deck(String cardType, int numberOfDecks) {
        try {
            for (int k = 0; k < numberOfDecks; k++) {
                for (int i = 1; i < 14; i++) {
                    for (int j = 0; j < 4; j++) {
                        deck.add(new PlayingCard(i, j, cardType));
                    }
                }
            }
        }catch (InvalidCardValueException e){
            clearDeck();
            System.out.println("Exception " + e);
        }
        this.shuffle();
    }

    public Deck(String cardType, boolean shuffle, int numberOfDecks) {
        try {
            for (int k = 0; k < numberOfDecks; k++) {
                for (int i = 1; i < 14; i++) {
                    for (int j = 0; j < 4; j++) {
                        deck.add(new PlayingCard(i, j, cardType));
                    }
                }
            }
        }catch (InvalidCardValueException e){
            clearDeck();
            System.out.println("Exception " + e);
        }
        if (shuffle) {
            this.shuffle();
        }
    }

    public Stack<PlayingCard> getDeck() {
        return this.deck;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public void sort(){
        deck.sort(PlayingCard::compareTo);
    }

    public PlayingCard drawCard(){
        return deck.pop();
    }

    public void addCard(PlayingCard c) {
        deck.add(c);
    }

    public void clearDeck() {
        deck.clear();
    }

    public void merge(ArrayList<PlayingCard> l) {
        deck.addAll(l);
    }

    public void merge(Deck d) {
        deck.addAll(d.getDeck());
    }

    public String toString(){
        return deck.toString();
    }

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
