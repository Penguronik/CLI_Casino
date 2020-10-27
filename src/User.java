public class User extends Player{

    private double money;

    //constructor 1
    public User(double money){
        this.setMoney(money);
    }

    public boolean lostCheck(int handNum) {
        if (hands.get(handNum).getTotal()>21 && !hands.get(handNum).contains(1)){
            return true;
        }// Figure out a place where Ace is checked for and stuff math
        return false;
    }

    //getters
    public double getMoney(){
        return this.money;
    }

    //setters
    public void setMoney(double money) {
        if (money > 0) {
            this.money = money;
        }else{
            throw new IllegalArgumentException("Money can't be negative");
        }
    }

}
