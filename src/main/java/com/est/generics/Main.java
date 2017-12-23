package com.est.generics;


import java.util.ArrayList;
import java.util.List;

/**
 * Java generics E - Element (used extensively by the Java Collections
 * Framework) K - Key N - Number T - Type V - Value S,U,V etc. - 2nd, 3rd, 4th
 * types
 *
 *
 * @author estevam
 */
public class Main {

    class engene {
    }

    class car extends engene {
    }

    class bike {
    }
List<car> fruits = new ArrayList<>();
List<? extends engene> frut =fruits;

    // determines the largest of three Comparable objects
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; // assume x is initially the largest       
        if (y.compareTo(max) > 0) {
            max = y; // y is the largest so far
        }
        if (z.compareTo(max) > 0) {
            max = z; // z is the largest now                 
        }
        return max; // returns the largest object   
    }

    public static void main(String args[]) {
        System.out.printf("Max of %d, %d and %d is %d\n\n",
                3, 4, 5, maximum(3, 4, 5));

        System.out.printf("Maxm of %.1f,%.1f and %.1f is %.1f\n\n",
                6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

        System.out.printf("Max of %s, %s and %s is %s\n", "pear",
                "apple", "orange", maximum("pear", "apple", "orange"));
    }
}
