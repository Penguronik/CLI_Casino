import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<PlayingCard> deck = new Stack<>();

    // makes the deck
    public Deck() throws InvalidCardValueException {
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new PlayingCard(i, j));
            }
        }
    }

    // makes the deck and shuffles it
    public Deck(boolean shuffle) throws InvalidCardValueException {
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new PlayingCard(i, j));
            }
        }
        if (shuffle) {
            shuffle();
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public PlayingCard drawCard(){
        return deck.pop();
    }
}
