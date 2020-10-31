public class User extends Player{

    private double balance;

    //constructor 1
    public User(double balance){
        this.setBalance(balance);
    }


    //getters
    public double getBalance(){
        return this.balance;
    }

    public double getBet(){return this.getHand(0).getBet();}

    public double getBet(int handNum){return this.getHand(handNum).getBet();}

    //setters
    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        }else{
            throw new IllegalArgumentException("Balance can't be negative");
        }
    }

    public void setBet(double bet){
        if (bet < 0) {
            throw new IllegalArgumentException("Bet can't be negative");
        }else if(bet > balance){
            throw new IllegalArgumentException("Bet can't be higher than balance");
        }else{
            this.getHand(0).setBet(bet);
            this.balance -= bet;
        }

    }

    public void setBet(double bet, int handNum){
        if (bet < 0) {
            throw new IllegalArgumentException("Bet can't be negative");
        }else if(bet > balance){
            throw new IllegalArgumentException("Bet can't be higher than balance");
        }else{
            this.getHand(handNum).setBet(bet);
            this.balance -= bet;
        }

    }

    public void split(int handNum){
        addHand(new Hand(getHand(handNum).getArray().get(0)));
        getHand(handNum).removeCard(1);
        setBet(getBet(handNum), handNum + 1);
    }
}
