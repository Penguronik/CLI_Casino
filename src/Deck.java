import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<PlayingCard> deck = new Stack<>();

    // makes the deck
    public Deck(String cardType) throws InvalidCardValueException {
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new PlayingCard(i, j, cardType));
            }
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
}
