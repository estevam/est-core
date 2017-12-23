/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.callFunctionByString;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class CallFunctionByString {

    public CallFunctionByString() {
    }

    public static void main(String args[]) {
        CallFunctionByString call = new CallFunctionByString();
        call.runScript("printMyFirstName");
        call.runScript("printMyLastName");
        call.runScript("printFullName");
    }

    private void runScript(String aMethod) {
        try {
            Method m = getClass().getDeclaredMethod(aMethod, (Class[]) null);
            m.invoke(this, (Object[]) null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(e);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CallFunctionByString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printMyFirstName() {
        System.out.println("Estevam");
    }

    public void printMyLastName() {
        System.out.println("Meneses");
    }

    public void printFullName() {
        System.out.println("Estevam Meneses");
    }
}
