/*
Author: Roni Kant
Date: Monday, November 9, 2020
Purpose: Has functions that can be performed on a player who has a hand
 */

import java.util.ArrayList;

public class Player {

    private ArrayList<Hand> hands = new ArrayList<>();

    //constructor
    public Player(){
    }

    //Get methods
    public Hand getHand(){
        return this.hands.get(0);
    }

    public Hand getHand(int handNum){
        return this.hands.get(handNum);
    }

    public ArrayList<Hand> getHands(){return this.hands;}

    public boolean checkBust(){
        return getHand().checkBust();
    }

    public boolean checkBust(int handNum){
        return getHand(handNum).checkBust();
    }

    //Set methods
    public void createHand(){
        hands.add(new Hand());
    }

    public void setHand(Hand hand){
        this.hands.set(0, hand);
    }

    public void setHand(Hand hand, int handNum){
        this.hands.set(handNum, hand);
    }

    public void addHand(Hand hand){
        this.hands.add(hand);
    }

    public void clearHands(){
        this.hands.clear();
    }

    public void clearHand(int handNum){
        this.hands.remove(handNum);
    }

    public void showAll(){
        for(Hand i: getHands()){
            i.showAll();
        }
    }

    //Action methods
    public void drawCard(Deck deck){
        hands.get(0).drawCard(deck);
    }

    public void drawCard(Deck deck, int handNum){
        hands.get(handNum).drawCard(deck);
    }

    public void drawCard(Deck deck, boolean show){
        hands.get(0).drawCard(deck,show);
    }

    public void drawCard(Deck deck, int handNum, boolean show){
        hands.get(handNum).drawCard(deck,show);
    }
}
