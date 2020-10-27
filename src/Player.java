public class Player {

    Hand hand; //No reason for this to be private as hand already has the restrictions from the Hand class
    private double money; //Planning on putting money on user instead and using player for both dealer and user

    //constructor 1
    public Player(){
        //This is what is run when it is extended
        this.money = 0;
    }
    //constructor 2
    public Player(long money) {
        setMoney(money);
    }

    //getters
    public double getMoney(){
        return this.money;
    }
    public Hand getHand(){
        return this.hand;
    }

    //setters
    public void setMoney(double money) {
        if (money > 0) {
            this.money = money;
        }else{
            throw new IllegalArgumentException("Money can't be negative");
        }
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void drawCard(Deck deck){
        hand.drawCard(deck);
        //Draw a card from the deck
    }

    public void drawCard(Deck deck, boolean show){
        if (show){
            hand.drawCard(deck, true);
        }else{
            hand.drawCard(deck);
        }
        //Draw a card from the deck
    }
}
