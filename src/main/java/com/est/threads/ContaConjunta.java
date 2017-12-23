
package com.est.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class ContaConjunta {
    
      private int saldo = 200;  
      
      public int getSaldo(){
          return saldo;
      }
      
    public synchronized void sacar(int valor, String client) {
                System.out.println("cliente vai sacar!");
        if (saldo >= valor) {
        
            int saldoOriginal = saldo;
            try {
                System.out.println(client + " esperando!");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ContaConjunta.class.getName()).log(Level.SEVERE, ex.toString());
            }
            
            saldo -= valor;
            String msg = client +"[sacou: "+ valor +"][Saldo original: "+  saldoOriginal + "]"+ "[Saldo final:"+ saldo + "]"; 
            
            System.out.println(msg);
        } else {
            System.out.println(client + " sem insuficiente para saque!");
        }
    }

}
