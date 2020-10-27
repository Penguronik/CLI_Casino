public class Player {

    Hand hand; //No reason for this to be private as hand already has the restrictions from the Hand class
    private double money;

    //constructor 1
    public Player(){
        //This is what is run when it is extended
        this.money = 0;
    }
    //constructor 2
    public Player(long money) throws NegativeMoneyException {
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
    public void setMoney(double money) throws NegativeMoneyException {
        if (money > 0) {
            this.money = money;
        }else{
            throw new NegativeMoneyException();
        }
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void drawCard(Deck deck){
        hand.drawCard(deck);
        //Draw a card from the deck
    }

}
