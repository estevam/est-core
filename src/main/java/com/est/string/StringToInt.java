/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.string;

/**
 *
 * @author estevam
 * 10/00/2007
 */
public class StringToInt {

    public int convertStringToInt(String aValue) {
        String a = aValue.trim();
        a = String.valueOf(a);
        return Integer.parseInt(a);
    }
}
