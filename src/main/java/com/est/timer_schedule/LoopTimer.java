/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.timer_schedule;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author estevam
 */


class LoopTimer {
 
   private static ScheduledExecutorService iTimer;
   private static final Object iMutex = new Object();

   public static void main(String[] args){
        startTime();
   }
   
   public static void startTime(){

        iTimer = Executors.newSingleThreadScheduledExecutor();
        iTimer.scheduleAtFixedRate(new BackTimer(), 1000, 1000, TimeUnit.MILLISECONDS);   
        

    }

// iTimer.shutdown();



    static class BackTimer implements Runnable {

        public int num = 0;

        @SuppressWarnings("deprecation")
		@Override
        public void run() {
            synchronized (iMutex) {
                try {
                    System.out.println("Test newSingleThreadScheduledExecutor " + num);
                    Calendar nowtime = Calendar.getInstance();
                    System.out.println("Time: " +nowtime.getTime().getHours() +":"+nowtime.getTime().getMinutes() +":"+nowtime.getTime().getSeconds());
                } catch (Exception ex) {
                    Logger.getLogger(BackTimer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            num++;

            if (num == 11) {
             //   iTimer.shutdown();
            }
        }

   }
   
// outro exemplo faz a mesma coisa
   
//    private Timer iTimerRefreshChat;
//    private int DELAY = 100;
//    private int PERIOD = 3000;
//
//
//// iTimerRefreshChat.cancel();
//
//
//
//        iTimerRefreshChat = new Timer();
//        iTimerRefreshChat.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                logger.info("refresh...");
//            }
//        }, DELAY, PERIOD);
//
//
//    }
}
