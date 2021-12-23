/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
@SuppressWarnings("deprecation")
public class OberverDemo {

    private static OberverDemo.myStatus iState = OberverDemo.myStatus.myStatus_Init;

    private static enum myStatus {

        myStatus_Init,
        myStatus_Activity,
        myStatus_Done,
        myStatus_Faild
    }

    @SuppressWarnings("unused")
	private static void changeState(OberverDemo.myStatus aState) {
        iState = aState;
    }

    public static void main(String args[]) {
        BeingWatch obervered = new BeingWatch();
        Watcher observing = new Watcher();

        obervered.addObserver(observing);
        obervered.counter(10);


        /*
         * addObserver(Obeserver Obj) 
         * clearChanged() // clear observer status
         * deleteObserver()   <-------------------- muito importante
         * hasChanged()
         * notifyObservers(Object Obj)
         * setChanged() // obj is changed
         */

    }

    static class Watcher implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("update() called: " + ((Integer) arg).intValue());
             System.out.println("State: "+ iState);
        }
    }

    static class BeingWatch extends Observable {

        @SuppressWarnings("removal")
		void counter(int period) {
            for (; period >= 0; period--) {
                setChanged();
                notifyObservers(new Integer(period));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(OberverDemo.class.getName()).log(Level.SEVERE, null, ex.toString());
                }

            }

        }
    }
}
