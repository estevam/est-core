
package com.est.threads;

/**
 *
 * @author estevam
 */
public class SimpleThread extends Thread {

    String palavra;
    long tempo;

    public SimpleThread(String palavra, long tempo) {
        super(palavra);
        this.palavra = palavra;
        this.tempo = tempo;
    }
    
    
    public static void main(String args[]){
    
        new SimpleThread("Ping", 2000).start();
        new SimpleThread("Pong", 1500).start();
        System.out.println("ver Thread!");
    }
    
    
    @Override
    public void run() {

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(palavra);
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
            return;  // metodo chegou ao fim para de executar
        }
    }

    
    
    
}
