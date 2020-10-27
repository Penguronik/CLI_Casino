public class Player {

    Hand hand;
    private long money;

    //constructor 1
    public Player(){
        this.money = 0;
    }
    //constructor 2
    public Player(long money){
        this.money = money;
    }

    public void drawCard(Deck deck){
        hand.drawCard(deck);
        //Draw a card from the deck
    }

}
