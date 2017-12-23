/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.threads;

/**
 *
 * @author estevam
 */
public class FirstTest {
    Runnable iTest;
    public static void main(String[] args) {

        System.out.println("ver Thread!");
        NamedThread greetings = new NamedThread("Estevam");
        greetings.start();
        
        greetings.isAlive();
        
        
    }
    
    public  static synchronized void  testNotify(NamedThread a){
     // a.notify();
    }
    
    public static class NamedThread extends Thread {

        private String name;  // The name of this thread.

        public NamedThread(String name) {  // Constructor gives name to thread.
            super(name); // thread name
            this.name = name;
        }
        
        @Override
        public void run() {  // The run method prints a message to standard output.
            System.out.println("Greetings from thread '" + name + "'!");
        }
    }
    
    public void testThread() {
         iTest = new Runnable() {
            @Override
            public void run() {
                System.out.println("Greetings from thread !'");
            }
        };
    }
}
