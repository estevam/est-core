
package com.est.threads;

/**
 *
 * @author estevam
 */
public class SimpleThreadRunnable implements Runnable {

    String palavra;
    long tempo;

    public SimpleThreadRunnable(String palavra, long tempo) {
        this.palavra = palavra;
        this.tempo = tempo;
    }
    
    
    public static void main(String args[]){
    
        SimpleThread ping = new SimpleThread("Ping", 2000);
        SimpleThread pong = new SimpleThread("Pong", 1500);
        System.out.println("Start Thread!");
        
        new Thread(ping,"ping").start();
        new Thread(pong,"pong").start();
       
    }
    
    
    @Override
    public void run() {

        try {
            for (int i = 0; i < 1000; i++) {
                System.out.println(palavra);
                Thread.sleep(tempo);
                
            }
        } catch (InterruptedException e) {
            System.out.println("Fim Thread!");
            return;  // metodo chegou ao fim para de executar
        }
    }

    
    
    
}
