public class PlayingCard {

    int cardValue, suitValue;
    String suitSymbol, valueString;

    // constructor 1 - takes 2 ints
    public PlayingCard(int v, int s) throws InvalidCardValueException {

        // setting value & valueString
        if (v > 13 || v < 1) {
            throw new InvalidCardValueException();
        }
        else {
            this.cardValue = v;
            switch (this.cardValue) {
                case (1):
                    this.valueString = "A";
                    break;
                case (11):
                    this.valueString = "J";
                    break;
                case(12):
                    this.valueString = "Q";
                    break;
                case(13):
                    this.valueString = "K";
                    break;
                default:
                    this.valueString = Integer.toString(this.cardValue);
                    break;
            }
        }

        // setting suit & suitValue
        if (s > 3 || s < 0) {
            throw new InvalidCardValueException();
        }
        else {
            switch (s) {
                case (0):
                    this.suitSymbol = "♠";
                    this.suitValue = 0;
                    break;
                case (1):
                    this.suitSymbol = "♥";
                    this.suitValue = 1;
                    break;
                case (2):
                    this.suitSymbol = "♣";
                    this.suitValue = 2;
                    break;
                default:
                    this.suitValue = 3;
                    this.suitSymbol = "♦";
                    break;
            }
        }
    }

    // constructor 2 - takes and int for value & a string for suit
    public PlayingCard(int v, String s) throws InvalidCardValueException {

        // setting value & valueString
        if (v > 13 || v < 1) {
            throw new InvalidCardValueException();
        }
        else {
            this.cardValue = v;
            switch (this.cardValue) {
                case (1):
                    this.valueString = "A";
                    break;
                case (11):
                    this.valueString = "J";
                    break;
                case(12):
                    this.valueString = "Q";
                    break;
                case(13):
                    this.valueString = "K";
                    break;
                default:
                    this.valueString = Integer.toString(this.cardValue);
                    break;
            }
        }

        // setting suit & suitValue
        if (!s.equals("♠") && !s.equals("♥") && !s.equals("♣") && !s.equals("♦")) {
            throw new InvalidCardValueException();
        }
        else {
            switch (s) {
                case ("♠"):
                    this.suitSymbol = "♠";
                    this.suitValue = 0;
                    break;
                case ("♥"):
                    this.suitSymbol = "♥";
                    this.suitValue = 1;
                    break;
                case ("♣"):
                    this.suitSymbol = "♣";
                    this.suitValue = 2;
                    break;
                default:
                    this.suitSymbol = "♦";
                    this.suitValue = 3;
                    break;
            }
        }
    }
}
