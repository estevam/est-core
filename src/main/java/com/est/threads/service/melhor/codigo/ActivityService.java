
package com.est.threads.service.melhor.codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public abstract class ActivityService implements Runnable {
    
    private Thread iThread;
    private final Object iLock = new Object();
    private int iThreadID;

    public ActivityService(int aThreadID) {
      iThreadID = aThreadID;
    }
    
    /**
     * Start Thread
     * @return boolean
     */
    public boolean start() {
        synchronized(iLock) {
            if (iThread != null) {
                return false;
            } 
        }
       // Start my action here
        iThread = new Thread(this);
        iThread.start();

        return true;
    }
    
    public void setPriorityThread(int aPriority) {        
        Thread t = Thread.currentThread();
        t.setPriority(aPriority);
    }
   
     public void setNameThread(String aNameThread) {        
        Thread t = Thread.currentThread();
        t.setName(aNameThread);
    }
   
    public Thread getCurrentThread(){ 
     return Thread.currentThread();
    }    
   /**
    *  Daemon Thread - It provides services to user threads for background supporting tasks.
    * It is a low priority thread.
    * @param aNameThread 
    */
    public void setDaemonThread(boolean aDaemonThread) {  
         Thread t = Thread.currentThread();
         t.setDaemon(aDaemonThread);
     
    }  
    
    public void shutdown() {
        synchronized (iLock) {
            iThread = null;
        }
    }
    
    @Override
    public void run() {
      
        if (iThread != Thread.currentThread()) {
            return;
        }
       
        
        System.out.println("will sleep: " + iThreadID);
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ActivityService.class.getName()).log(Level.SEVERE, ex.toString());
        }
        System.out.println("Thread playing: " + iThreadID);
   
        Object obj = onAction();
         
        System.out.println("Action: " + iThreadID);
        
      //  final ActivityService p = this;
      //final Object o = obj;
         
        System.out.println(obj.toString() +" "+ iThreadID);
//        UIApplication.instance().execute(new UITask() {
//            @Override
//            public void exec() {
//                iController.close();
//                shutdown();
//                iDelegate.onActivityComplete(p, o);
//            }
//        });
        
         shutdown();
    }
   public void closeDialog(){
      //  iController.close();
    }
    public abstract Object onAction();
}