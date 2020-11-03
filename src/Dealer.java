public class Dealer extends Player{
    public boolean shouldHit(){
        return getHand().getTotal() < 17;
    }
}
