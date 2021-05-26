package com.Player;
import java.util.ArrayList;

public class Hand {
    boolean isDeealer;
    private boolean isBusted = false;
    private ArrayList<Card> playerCards = new ArrayList<Card>();
    private Deck deck;
    private int totalPoints;
    private String playerName;

    public Hand(boolean isDealer, Deck aDeck, String aPlayerName ) {
        this.deck = aDeck;
        this.isDeealer = isDealer;
        this.totalPoints = 0;
        this.playerName = aPlayerName;

    }

    // call this method when you want to drop all cards from a player or dealer
    public void resetHand() {
        playerCards.clear();
        this.totalPoints = 0;
        this.isBusted=false;
    }

    public void demandCard() {
        if (!isBusted) {
            if(this.isDeealer){
                if(playerCards.size()==1) {
                    playerCards.add(deck.returnCard(true));
                }
                else {
                    playerCards.add(deck.returnCard( false));
                }
            }else {
                    playerCards.add(deck.returnCard(false));
            }

        } else {
            System.out.println("Player is busted");
        }
        // after adding a new card check if player is busted or not. If is busted change isBusted attr to True
        calculateTotal();
        if (this.totalPoints > 21) {
            this.isBusted = true;
            System.out.println("Player " + this.getPlayerName() + " is busted with an total of " + this.getTotalPoints());
        }


    }

    public void printHand(){
        System.out.println("Player "+ this.getPlayerName() + "  have following cards");
        System.out.println("--------------------------------------------------");
        for(Card c:playerCards){
            if(c.getHidden()){
                System.out.println("anonymous  anonymous");
            }else{
                System.out.println(c.getValue() + "  " + c.getSuit());
            }
        }
        System.out.println("--------------------------------------------------");
    }
    // call this function every time a new card is added to the hand:
    // 1)Check if player have an ACE and is Busted,then change ace/s values
    private void calculateTotal(){
        ArrayList<Integer> positionAcces= new ArrayList<Integer>();
        this.totalPoints=0;
        for(Card c:playerCards) {
            if(c.getValue()==11) positionAcces.add(playerCards.indexOf(c));
            this.totalPoints+= c.getValue();
        }
        if (this.totalPoints > 21 && positionAcces.size() > 0){
            while(this.totalPoints>21 && positionAcces.size()>0){
                playerCards.get(positionAcces.get(0)).setValue(1);
                this.totalPoints-=10;
            }
        }

    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public void dealCards() {
        demandCard();
        demandCard();
    }

    public boolean isBusted() {
        return isBusted;
    }

    protected void dealerHitAction(){
        this.playerCards.get(1).setHidden(false);//change the value of the hidden card to False
        while(this.totalPoints<=17){
            demandCard();
        }
        printHand();
    }

    private String getPlayerName() {
        return playerName;
    }
}
