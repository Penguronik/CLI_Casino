import com.sun.javaws.exceptions.InvalidArgumentException;

public class PlayingCard{

    private int cardValue;
    private final int suitValue;

    private final String suitSymbol;
    private final String cardValueString;

    private boolean show = false;

    // constructor 1 - for blackjack values
    public PlayingCard(int v, int s, String cardType) throws InvalidCardValueException {

        if (cardType.equals("bj")) {
            // setting value & valueString
            if (v > 13 || v < 1) {
                throw new InvalidCardValueException();
            }
            else {
                switch (v) {
                    case (1):
                        this.cardValueString = "A";
                        this.cardValue = 1;
                        break;
                    case (11):
                        this.cardValueString = "J";
                        this.cardValue = 10;
                        break;
                    case(12):
                        this.cardValueString = "Q";
                        this.cardValue = 10;
                        break;
                    case(13):
                        this.cardValueString = "K";
                        this.cardValue = 10;
                        break;
                    default:
                        this.cardValue = v;
                        this.cardValueString = Integer.toString(this.cardValue);
                        break;
                }
            }

            // setting suit & suitValue
            if (s > 3 || s < 0) {
                throw new InvalidCardValueException();
            }
            else {
                switch (s) {
                    case (3):
                        this.suitSymbol = "♠";
                        this.suitValue = 0;
                        break;
                    case (2):
                        this.suitSymbol = "♥";
                        this.suitValue = 1;
                        break;
                    case (1):
                        this.suitSymbol = "♦";
                        this.suitValue = 2;
                        break;
                    default:
                        this.suitValue = 3;
                        this.suitSymbol = "♣";
                        break;
                }
            }
        }
        else {
            throw new IllegalArgumentException("cardType is invalid");
        }
    }


    // get methods
    public String toString() {
        return cardValueString + suitSymbol;
    }

    public int getCardValue() {
        return this.cardValue;
    }

    public int getSuitValue(){return this.suitValue;}

    // set methods
    public PlayingCard setShow(boolean b) {
        this.show = b;
        return this;
    }

    public void setCardValue(int v) {
        this.cardValue = v;
    }

}
