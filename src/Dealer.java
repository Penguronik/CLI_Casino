/*
Author:
Date: Monday, November 9, 2020
Purpose:
 */

public class Dealer extends Player{
    //This is a very empty class but Dealer is technically different than User and the Player class already has most of the methods it requires
    //Checks if dealer should hit
    public boolean shouldHit(){
        return getHand().getTotal() < 17;
    }
}
