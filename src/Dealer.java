/*
Author: Roni Kant
Date: Monday, November 9, 2020
Purpose: Create the dealer class which extends player in order to implement the dealer's game-logic
 */

public class Dealer extends Player{
    //This is a very empty class but Dealer is technically different than User and the Player class already has most of the methods it requires
    //Checks if dealer should hit
    public boolean shouldHit(){
        return getHand().getTotal() < 17;
    }
}
