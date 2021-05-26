package com.Player;


public class Player {
    private String playerName;
    private int balance;
    Hand hand;
    private boolean isDealer = false;

    public Player(String aName, int aAmount, boolean isDealer, Deck aDeck) {
        this.playerName = aName;
        this.balance = aAmount;
        this.isDealer =isDealer;
        this.hand = new Hand(isDealer, aDeck,this.playerName);
    }


    public void playerHitAction(){
        this.hand.demandCard();
        this.hand.printHand();
    }

    public void showCards(){
        if(isDealer){
            System.out.println("Dealer started to hit cards");
            this.hand.dealerHitAction();
        }else{
            System.out.println("Action not allowed for this instance, must be an DEALER Instance");
        }

    }

    public void dealCards(){
        this.hand.dealCards();
    }

    public boolean isBusted(){
        return this.hand.isBusted();
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public int getPlayerPoints(){
        return this.hand.getTotalPoints();
    }
}
