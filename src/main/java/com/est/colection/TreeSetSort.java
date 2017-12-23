/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.est.colection;
import java.util.Iterator;
import java.util.TreeSet;
/**
 * You can use  TreeSet that automatically order list values:
 * @author estevam
 */
public class TreeSetSort {
   
         public static void main(String[] args) {
        System.out.println("Tree Set Example!\n");

        TreeSet <String>tree = new TreeSet<String>();
        tree.add("aaa");
        tree.add("acbbb");
        tree.add("aab");
        tree.add("c");
        tree.add("a");

        Iterator<String> iterator;
        iterator = tree.iterator();

        System.out.print("Tree set data: ");

        //Displaying the Tree set data
        while (iterator.hasNext()){
             System.out.print("\n ");
            System.out.print(iterator.next());
        }
    }
}
