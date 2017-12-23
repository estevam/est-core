/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.scanner;

import java.util.Scanner;

/**
 *
 * @author estevam
 */
public class MyScanner {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        System.out.print("Please enter user name: ");
        String username = in.nextLine();
        System.out.println("You entered : " + username);
    }
}
