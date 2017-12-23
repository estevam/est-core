/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.est.timer_schedule;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class SingleTimerLocker {
    
   private static ScheduledExecutorService iTimer;
   private static final Object iMutex = new Object();

   public static void main(String[] args){
        startTime();
   }
   
   public static void startTime(){

        iTimer = Executors.newScheduledThreadPool(1);
        iTimer.schedule(new BackTimer(), 5, TimeUnit.SECONDS);   
      
    }

    static class BackTimer implements Runnable, Lock {

        public int num = 0;

        @SuppressWarnings("deprecation")
		@Override
        public void run() {
             System.out.println("Test newSingleThreadScheduledExecutor " + num);
            synchronized (iMutex) {
                try {
                    System.out.println("Test newSingleThreadScheduledExecutor " + num);
                    Calendar nowtime = Calendar.getInstance();
                    System.out.println("Time: " +nowtime.getTime().getHours() +":"+nowtime.getTime().getMinutes() +":"+nowtime.getTime().getSeconds());
                } catch (Exception ex) {
                    Logger.getLogger(BackTimer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            
           
               iTimer.shutdown();
            
        }

		@Override
		public void lock() {
		}

		@Override
		public void lockInterruptibly() throws InterruptedException {
		}

		@Override
		public boolean tryLock() {
			return false;
		}

		@Override
		public boolean tryLock(long time, TimeUnit unit)
				throws InterruptedException {
			return false;
		}

		@Override
		public void unlock() {
		}

		@Override
		public Condition newCondition() {
			return null;
		}
   }
}
