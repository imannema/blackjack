package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


//Deck of cards class. 52 individual cards, shuffled and dealt.

public class Deck {

    //hold cards in arraylist
    ArrayList<Cards> deck;

    //initialize a new deck, with all 52 cards
    public Deck(){
        deck = new ArrayList<>();

        String[] rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suit = {"Hearts","Diamonds","Spades","Clubs"};

        int index = 0;
        for(String i:suit){
            for(String j: rank){
                deck.add(new Cards(j,i));
                index++;
            }
        }
    }

    // shuffle method to randomly shuffle the deck
    public void shuffle(){
        Collections.shuffle(deck);
    }

    // deals the first card on top of the deck
    public Cards dealCard(){
        Cards dealt = deck.get(0);
        deck.remove(0);
        return dealt;
    }

    // gets the number of cards left in the deck
    public int deckSize(){
        return deck.size();
    }
}
