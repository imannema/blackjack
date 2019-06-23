package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    ArrayList<Cards> dealersHand;
    ArrayList<Cards> playersHand;
    Deck deck;

    public BlackJack(){
        deck = new Deck();
        deck.shuffle();
        dealersHand = new ArrayList<>();
        playersHand = new ArrayList<>();

        for(int i = 0; i < 2; i++){
            playersHand.add(deck.dealCard());
            dealersHand.add(deck.dealCard());
        }
        System.out.println("Your Cards: " + playersHand);
        System.out.println("Dealer is showing: " + dealersHand.get(1));
        playerOption();
    }

    public void playerOption(){
        while(handTotal(playersHand) < 21) {
            System.out.println("You now have: " + handTotal(playersHand));
            System.out.println("Hit or Stay? (h / s)");
            Scanner decision = new Scanner(System.in);
            if (decision.next().equals("s")) {
                dealerOption();
            }
            if (decision.next().equals("h")) {
                Cards dealt = deck.dealCard();
                System.out.println("Dealt: " + dealt);
                playersHand.add(dealt);
                System.out.println("Your Cards: " + playersHand);
            }
            if(handTotal(playersHand) > 21){
                System.out.println("You now have: " + handTotal(playersHand));
                System.out.println("Player Busts! You lose.");
            }
        }
        dealerOption();

    }

    public void dealerOption(){
        System.out.println("Dealer's Cards: " + dealersHand);
        while(handTotal(dealersHand) < 17){
            Cards dealt = deck.dealCard();
            System.out.println("Dealt: " + dealt);
            dealersHand.add(dealt);
            System.out.println("Dealer's Cards: " + dealersHand);
            System.out.println("Dealer now has: " + handTotal(dealersHand));

            if(handTotal(dealersHand) > 21){
                System.out.println("Dealer Busts!");
            }
        }
        finalDecision();
    }

    public void finalDecision(){
        System.out.println("*************************************************");
        System.out.println("Your total: " + handTotal(playersHand));
        System.out.println("Dealer's total: " + handTotal(dealersHand));
        if(handTotal(playersHand) <= 21 && handTotal(dealersHand) <= 21){
            if(handTotal(playersHand) > handTotal(dealersHand)){
                System.out.println("You Win!");
            }
            else if (handTotal(playersHand) < handTotal(dealersHand)){
                System.out.println("You Lose!");
            }
            else{
                System.out.println("Push!");
            }
        }
        else if(handTotal(playersHand) > 21 && handTotal(dealersHand) > 21 ){
            System.out.println("You Both Busted!");
        }
        else if(handTotal(playersHand) > 21){
            System.out.println("You Busted!");
            System.out.println("You Lose!");
        }
        else if(handTotal(dealersHand) > 21){
            System.out.println("Dealer Busted!");
            System.out.println("You Win!");
        }

        System.out.println("*************************************************");
        return;
    }

    public int handTotal(ArrayList<Cards> person){
        int total = 0;
        for(Cards c:person){
            try {
                total += Integer.valueOf(c.getValue());
            }
            catch (NumberFormatException e){
                if(c.getValue().equals("A")){
                    total += 1;
                }
                else{
                    total += 10;
                }
            }
        }
        return total;
    }
}
