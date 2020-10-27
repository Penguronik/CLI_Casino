public class User extends Player{

    //constructor 1
    public User(double money){
        this.setMoney(money);
    }

    public boolean lostCheck() {
        if (hand.getTotal()>21 && !hand.contains(1)){
            return true;
        }// Figure out a place where Ace is checked for and stuff math
        return false;
    }
}
