package com.est.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class ThreadFunctions {

    /**
     * Deadlock - A concurrent application has the risk of a deadlock. A set of
     * processes are deadlocked if all processes are waiting for an event which
     * another process in the same set has to cause.
     */
    private static Thread iMyThread;
    private static List<Thread> iThreadsList = new ArrayList<Thread>();

    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        System.out.println(id);
        System.out.println(name);
        iMyThread = new Thread(new MyRunnable(), "myRunnable");
        iMyThread.start();
        iThreadsList.add(iMyThread);

        iMyThread = new Thread(new MyRunnable(), "myRunnable");
        iMyThread.start();
        iThreadsList.add(iMyThread);
    }

    public long getCurrentThreadId() {
        return Thread.currentThread().getId();
    }

    public String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public void setThreadPriority() {
      // Thread.currentThread().

        //iMyThread.setPriority(newPriority);
    }

    public void checkHowManyThreadAlive() {
        int running = 0;
        for (Thread thread : iThreadsList) {
            if (thread.isAlive()) {

                running++;
                thread.setPriority(5);

            }
        }
        System.out.println("We have " + running + " running threads. ");
    }

    public void createThreadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(iMyThread);

        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();

        try {
            // Wait until all threads are finish
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Finished all threads");

    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Executing thread " + Thread.currentThread().getName());
        }

    }

}
