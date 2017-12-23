/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author estevam
 */
public class SimpleSort {

    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    public List< String> list = Arrays.asList(suits);

    public static void main(String[] args) {

        SimpleSort s = new SimpleSort();
        s.ascendingOrder();
        s.descendingOrder();

    }

    public void ascendingOrder() {
        System.out.printf("Unsorted array elements: %s\n", list);
        Collections.sort(list); // sort ArrayList
        System.out.printf("Sorted list elements: %s\n", list);

    }

    public void descendingOrder() {

        // sort in descending order using a comparator
        Collections.sort(list, Collections.reverseOrder());

        System.out.printf("descending order list elements: %s\n", list);
    }
}
