package com.company;

/* Each card has a suit and a value.
   This class will get the value of each card and be able to calculate combinations of cards
 */
public class Cards {

    private String value;
    private String suit;

    //initialize card with a value and a suit
    public Cards(String value, String suit){
        this.value = value;
        this.suit = suit;
    }

    //the value of cards are their numbers, Jacks, Queens and Kings have value 10
    // Ace has value of 1 or 11 and is calculated in Blackjack.java
    public String getValue(){
        if(value.equals("J")||value.equals("Q")||value.equals("K")){
            return "10";
        }
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
