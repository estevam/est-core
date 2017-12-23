/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.lendo_string_teclado;

import java.util.Scanner;

/**
 *
 * @author estevam
 */
@SuppressWarnings("resource")
public class LendoStringTeclado {

    public static void main(String[] args) {
  
		Scanner in = new Scanner(System.in);
        System.out.print("Please enter user name: ");
        String username = in.nextLine();
        System.out.println("You entered : " + username);
    }
}
