/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.observer;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author estevam
 */
public class MyObeserverTest {

    public static void main(String[] args) {

        MyObservable myObservableObject = new MyObservable();
        myObservableObject.addObserver(new MyObserver());
        myObservableObject.setInt(5);
        myObservableObject.setInt(15);
    }

    static class MyObservable extends Observable {

        int integerToBeObserved;

        public void setInt(int i) {
            integerToBeObserved = i;
            setChanged();
            notifyObservers(i);
        }

        public int getInt() {
            return integerToBeObserved;
        }
    }

    static class MyObserver implements Observer {

        @Override
        public void update(Observable obs, Object arg) {
             System.out.println("update() called: " +((Integer) arg).intValue());
         }
    }
}
