/*
Author:
Date: Monday, November 9, 2020
Purpose:
 */

public class PlayingCard implements Comparable<PlayingCard> {

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
                // in case the value is a J, Q, K, A
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
                // sets the suit
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
    public int getCardValue() {
        return this.cardValue;
    }

    // returns the value assigned to the specific suit
    public int getSuitValue(){return this.suitValue;}

    // returns the symbol of the suit
    public String getSuitSymbol() { return this.suitSymbol; }

    // returns the card in string form
    public String toString() {
        if(show){
            return cardValueString + suitSymbol;
        }else{
            return "▣";
        }
    }

    // set methods
    public PlayingCard setShow(boolean b) {
        this.show = b;
        return this;
    }

    // sets the value of the card
    public void setCardValue(int v) {
        this.cardValue = v;
    }

    // compareTo() method
    public int compareTo(PlayingCard pc) {
        if (cardValue < pc.getCardValue()) {
            return -1;
        }
        else if (cardValue == pc.getCardValue()) {
            if (suitValue < pc.suitValue) {
                return -1;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }

}
