package com.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final String[] suitModel = new String[]{"Clubs", "Diamond", "Hearts", "Spades"};
    private ArrayList<Card> deckCards = new ArrayList<>();

    public Deck(){
        populateDeck();
        shuffleCards();
    }
    // call this function to populate deck with cards
    public void populateDeck(){
        for(int i=2; i<=14; i++){
            for(String suit: suitModel){
                Card card = Card.createCard(i, suit);
                deckCards.add(card);
            }

        }
    }

    public void printDeck(){
        for(Card c:deckCards){
            System.out.println("This card value is " + c.getValue()+ " with a suit of " + c.getSuit());
        }
    }

    public void shuffleCards(){
        Collections.shuffle(deckCards);
        Collections.shuffle(deckCards);
    }

    //here we pick a card from a shuffle deck of cards. We delete that card from deck Arrray List
    public Card returnCard(boolean isHidden){
        Card removed = deckCards.remove(deckCards.size()-1);
        removed.setHidden(isHidden);
        return removed;
    }
    // when a game is over, we delete all cards instances from a deck and then we contruct another deck of cards
    public void resetDeck(){
        deckCards.clear();
        populateDeck();
        shuffleCards();

    }

    public void printTotalCards(){
        System.out.println("Deck have a total of " + deckCards.size() + " cards");
    }
}
