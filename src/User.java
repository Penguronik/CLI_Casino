import com.sun.javaws.exceptions.InvalidArgumentException;

public class User extends Player{

    private double balance;
    private double bet;

    //constructor 1
    public User(double balance){
        this.setBalance(balance);
    }


    //getters
    public double getBalance(){
        return this.balance;
    }

    public double getBet(){return this.bet;}

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
            this.bet = bet;
        }

    }

}
