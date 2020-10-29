import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.UUID;

public class User extends Player{

    private double balance;
    private double bet;
    private short playerID;

    //constructor 1
    public User(double balance){
        this.setBalance(balance);
    }


    //getters
    public double getBalance(){
        return this.balance;
    }

    public double getBet(){return this.bet;}

    public short getPlayerID(){return this.playerID;}

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

    public void setPlayerID(short playerID) {
        this.playerID = playerID;
    }
}
