package com.Player;

import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Deck deck = new Deck();
        Player gabriel = new Player("Gabriel", 1000, false, deck);
        Player dealer = new Player("Dealer", 0, true, deck);

        boolean quit = false;
        while (!quit){
            printCommands();
            int commnand = scanner.nextInt();
            switch (commnand) {
                case 1 -> startGame(deck,gabriel,dealer);
                case 2 -> quit = true;
            }

         }
    }

    public static void printCommands(){
        System.out.println("Commands:");
        System.out.println("1. For starting a new game");
        System.out.println("2. Quit");
    }

    public static void printGameCommands(){
        System.out.println("Game commands :");
        System.out.println("1. Hit ");
        System.out.println("2. Stand ");
        System.out.println("3. Place a bet ");
    }
    public static void startGame(Deck deck,Player player, Player dealer){
        resetGame(deck,player, dealer);
        System.out.println("Game started");
        player.dealCards();
        dealer.dealCards();
        player.hand.printHand();
        dealer.hand.printHand();

        while(!player.hand.isBusted()){
            printGameCommands();
            int command = scanner.nextInt();
            if(command==1){
                player.playerHitAction();
            }else{
                dealer.showCards();
                break;
            }
        }
        System.out.println("Game over :");
        if(player.isBusted()){
            System.out.println("!!! Player " +  player.getPlayerName() + " is busted with an total of " + player.getPlayerPoints());
        }else if (dealer.isBusted()){
            System.out.println("!!! Player " +  dealer.getPlayerName() + " is busted with an total of " + dealer.getPlayerPoints());
        }else{
            if(player.getPlayerPoints()> dealer.getPlayerPoints()){
                System.out.println("!!! Player " +  player.getPlayerName() + " is WINNER with total of " + player.getPlayerPoints() + " over opponent points " + dealer.getPlayerPoints());
            }else{
                System.out.println("!!! Player " +  dealer.getPlayerName() + " is WINNER with total of " + dealer.getPlayerPoints() + " over opponent points " + player.getPlayerPoints());
            }
        }

        }

        public static void resetGame(Deck aDeck, Player player, Player dealer){
            aDeck.resetDeck();
            player.hand.resetHand();
            dealer.hand.resetHand();
        }

    }
