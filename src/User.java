public class User extends Player{

    private double money;

    //constructor 1
    public User(double money){
        this.setMoney(money);
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
