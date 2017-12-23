/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.threads;

import java.util.Random;

/**
 *
 * @author estevam
 */
public class PrintTask implements Runnable {

    private final int sleepTime;
    private final String taskName;
    private final static Random generator = new Random();

    public PrintTask(String name) {
        taskName = name; // set task name
        // pick random sleep time between 0 and 5 seconds
        sleepTime = generator.nextInt(5000); // milliseconds
    }

    @Override
    public void run() {
        // put thread to sleep for sleepTime amount of time
        try {
            System.out.printf("%s going to sleep for %d milliseconds.\n", taskName, sleepTime);
            Thread.sleep(sleepTime); // put thread to sleep 
        } catch (InterruptedException exception) {
            System.out.printf("%s %s\n", taskName,
                    "terminated prematurely due to interruption");
        } // end catch
        // print task name
        System.out.printf("%s done sleeping\n", taskName);
    } // end method run
} // en

