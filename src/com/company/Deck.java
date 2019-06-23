package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    //public Cards[] deck;
    ArrayList<Cards> deck;

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

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Cards dealCard(){
        Cards dealt = deck.get(0);
        deck.remove(0);
        return dealt;
    }

    public int deckSize(){
        return deck.size();
    }
}
