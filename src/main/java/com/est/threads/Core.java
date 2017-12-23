/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.threads;

/**
 *
 * @author estevam
 */
public class Core {

    public static void main(String[] args) {
        Runnable r0, r1;//pointers to thread methods
        r0 = new FirstIteration(); //init Runnable 
        r1 = new SecondIteration();
        Thread t0, t1;//Thread class is used for starting a thread (runnable instance)
        t0 = new Thread(r0);//init thread object, but haven't started yet
        t1 = new Thread(r1);
        t0.start();//start the thread simultaneously
        t1.start();
        
        System.out.print("Threads started, no surprise here!\n");
    }
}

class FirstIteration implements Runnable {

    @Override
    public void run() {//thread starts from here
        for (int i = 0; i < 20; i++) {
            System.out.print("Hello from 1st. thread, iteration=" + i + "\n");
        }
    }
}

class SecondIteration implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.print("who just called 2st. thread? iteration=" + i + "\n");
        }
    }
}
