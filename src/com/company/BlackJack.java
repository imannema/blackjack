package com.company;

import java.util.ArrayList;
import java.util.Scanner;

// Blackjack.java contains the main decision making and game play.
public class BlackJack {
    // We will use an ArrayList to keep track of the player and dealer hands
    ArrayList<Cards> dealersHand;
    ArrayList<Cards> playersHand;
    Deck deck;

    /*
    When playing a new game, a new deck is shuffled and both the dealer and player are initially given two cards each.
     */
    public BlackJack(){
        deck = new Deck();
        deck.shuffle();
        dealersHand = new ArrayList<>();
        playersHand = new ArrayList<>();

        //deal 2 cards to each
        for(int i = 0; i < 2; i++){
            playersHand.add(deck.dealCard());
            dealersHand.add(deck.dealCard());
        }

        // display cards to player and top card of dealer
        System.out.println("Your Cards: " + playersHand);
        System.out.println("Dealer is showing: " + dealersHand.get(1));
        playerOption();
    }

    /*
    This method determines the decision made by the player based on their cards.
    The player has a decision to either hit for a new card or stay.
     */
    public void playerOption(){
        //if player is initially dealt blackjack, they are automatically told and it goes straight to the dealer
        if( handTotal(playersHand)==21){
            System.out.println("BlackJack!");
            dealerOption();
        }
        else {
            //The player is given the option to hit or stay until they bust
            while (handTotal(playersHand) < 21) {
                System.out.println("You now have: " + handTotal(playersHand));
                System.out.println("Hit or Stay? (h / s)");
                Scanner decision = new Scanner(System.in);
                String input = decision.next();
                //if the player chooses to stay, go to the dealer's turn
                if (input.equals("s")) {
                    dealerOption();
                }
                //if player chooses to hit, deal them the next card
                if (input.equals("h")) {
                    Cards dealt = deck.dealCard();
                    System.out.println("Dealt: " + dealt);
                    playersHand.add(dealt);
                    System.out.println("Your Cards: " + playersHand);
                }
                //player busts if they go over 21
                if (handTotal(playersHand) > 21) {
                    System.out.println("You now have: " + handTotal(playersHand));
                    System.out.println("Player Busts! You lose.");
                }
            }
            dealerOption();
        }
    }

    /*
      This method operates the dealer's turn. They must hit until they reach 17 or higher
     */
    public void dealerOption(){
        System.out.println("Dealer's Cards: " + dealersHand);
        // dealer must keep hitting until they reach 17 or higher
        while(handTotal(dealersHand) < 17 && handTotal(playersHand) <= 21){
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

    /*
    Determines who the winner of the game is after everyone receives all of their cards.
     */
    public void finalDecision(){
        System.out.println("*************************************************");
        System.out.println("Your total: " + handTotal(playersHand));
        System.out.println("Dealer's total: " + handTotal(dealersHand));
        // if no one busted, compare their values
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
        // if you both busted, you still lose because you busted
        else if(handTotal(playersHand) > 21 && handTotal(dealersHand) > 21 ){
            System.out.println("You Both Busted!");
            System.out.println("You Lose!");
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
        System.exit(0);
        return;
    }

    /*
    Calculates the hand value given the cards you have
     */
    public int handTotal(ArrayList<Cards> person){
        //hand total
        int total = 0;
        // number of aces in your hand
        int num_aces = 0;
        // go through all the cards in your hand
        for(Cards c:person){
            //calculate the numerical value of each card from string to int
            try {
                total += Integer.valueOf(c.getValue());
            }
            // if card is an Ace, count it as 11 for now
            catch (NumberFormatException e){
                if(c.getValue().equals("A")){
                    //increase the number of aces
                    num_aces++;
                    total += 11;
                    }
                }
            }
        /* if your value is over 21, but you have aces in your hand. Change the value of the ace from 11 to 1
         for as many aces you have until you are below 21. This will ensure you reach the closest possible number to 21.
         */
        if(num_aces>0 && total>21){
            while(total>21 && num_aces>0){
                total -= 10;
                num_aces -= 1;
            }
        }
        return total;
    }
}
