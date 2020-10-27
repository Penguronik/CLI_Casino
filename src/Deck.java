import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<PlayingCard> deck = new ArrayList<>();

    public Deck() throws InvalidCardValueException {
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new PlayingCard(i, j));
            }
        }
        shuffle();
    }
    public Deck(boolean shuffle) throws InvalidCardValueException {
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new PlayingCard(i, j));
            }
        }
        if(shuffle){
            shuffle();
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }
}
