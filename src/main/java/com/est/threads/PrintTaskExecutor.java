/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class PrintTaskExecutor {

    public static void main(String[] args) {

        PrintTask task1 = new PrintTask("task3");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task1");

        System.out.println("Starting Executor");
        // create ExecutorService to manage threads
        ExecutorService threadExecutor = Executors.newCachedThreadPool();

        // start threads and place in runnable state 21
        threadExecutor.execute(task1);
        threadExecutor.execute(task2);
        threadExecutor.execute(task3);

        // wait 1 minute for both writers to finish executing
        boolean tasksEnded = false;
        try {
            //timeout - the maximum time to wait unit - the time unit of the timeout argument
            tasksEnded = threadExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(PrintTaskExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(threadExecutor.isTerminated()){
          threadExecutor.shutdown();

        }
        
        if (tasksEnded) {
            System.out.println("tasks ended");
        }
        
        // shut down worker threads when their tasks complete
        threadExecutor.shutdown();

        System.out.println("Tasks started, main ends.\n");
    }
} // end class TaskExecutor

