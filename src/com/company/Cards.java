package com.company;

public class Cards {

    private String value;
    private String suit;

    public Cards(String value, String suit){
        this.value = value;
        this.suit = suit;
    }


    public int addValues(Cards c){
        int value1;
        int value2;
        try {
            value1 = Integer.valueOf(value);
        }
        catch (NumberFormatException e){
            if(value.equals("A")){
                value1 = 1;
            }
            else{
                value1 = 10;
            }
        }
        try {
            value2 = Integer.valueOf(c.value);
        }
        catch (NumberFormatException e){
            if(c.value.equals("A")){
                value2 = 1;
            }
            else{
                value2 = 10;
            }
        }
        return value1 + value2;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
