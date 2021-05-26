package com.Player;

public class Card {
    private Boolean isHidden=false;
    private int value;
    private String suit;

    public Card(int aValue, String aSuit){
        this.value = aValue ;
        this.suit = aSuit;

    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public static Card createCard(int aValue, String aSuit){
        return new Card(aValue, aSuit);
    }


    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
