/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.int_code;

/**
 *
 * @author estevam
 */
public class WorkWithInt {

    /**
     * Check if String is Integer
     *
     * @param s
     * @return
     */
    @SuppressWarnings("unused")
	private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
