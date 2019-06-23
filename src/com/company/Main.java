package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Deck d = new Deck();
        Cards one = d.deck.get(0);
        Cards two = d.deck.get(13);
        //System.out.print(one.addValues(two));
        System.out.println(d.deck);
        d.dealCard();
        System.out.println(d.deck);
        d.shuffle();
        System.out.println((d.deck));
        d.shuffle();
        System.out.println((d.deck));
//        System.out.print("Enter a number:");
//        Scanner input = new Scanner(System.in);
//        System.out.print(input.next());
    }
}
