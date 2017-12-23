/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.garbage_collector;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estevam
 */
public class GarbageCollector {
    /*
     *        Runtime
     *     . gc                // reciclagem de objetos n mais usados para a memoria ser reutilizada
     *     . runFinalization() // finalizador de objeto 
     *     . freeMemory()      // estimativa de bytes livres na memoria do sistema
     *     . totalMemory      // total bytes na moria
     *     . mxMemory()       // quantidade maxima em bytes q a memoria vai tentar utilizar
     *     
     */
 
    public static void main(String[] args){
           
        Runtime  rt = Runtime.getRuntime();
        int mb = 1048576;// total de bytes em 1MB
        double total = rt.maxMemory() /mb; 
        System.out.println(total +" MB disponivel na memoria"); 
        double inicio = total - (carregarMemoria() / mb);
         
        
        rt.runFinalization();
        rt.gc(); // limpa objeto
        
        double fim = total - (rt.freeMemory() / mb);
        
        System.out.println(inicio +" MB memoria utilizada \n" + fim +" memoria livre"); 
      
    }
    
    public static long carregarMemoria(){
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i =0; i < 100000; i++){
          list.add(i);
        }
        
        return Runtime.getRuntime().freeMemory();
    
    }
}
