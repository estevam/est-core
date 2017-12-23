/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

/**
 *
 * @author estevam
 */

import java.util.*;
@SuppressWarnings("rawtypes")

public class TestaVelocidadeColecoes {

    public static void main(String args[]) {
        
      
		ArrayList arrayList = new ArrayList(); // mais rapida para exibir dados
        LinkedList linkedList = new LinkedList<Object>();
        HashSet hashSet = new HashSet();
        @SuppressWarnings("unused")
		HashMap hashMap = new HashMap(); // mais rapida para pesquisar e excluir
        
        // LinkedList -  Note that this implementation is not synchronized
        //List list = Collections.synchronizedList(new LinkedList(...));
        
        long tempo = TestaVelocidadeColecoes.AdicionaNoFinal(arrayList);
        System.out.println("ArrayList: " + tempo + "ms");
        
        tempo = TestaVelocidadeColecoes.AdicionaNoFinal(linkedList);
        System.out.println("LinkedList: " + tempo + "ms");
        
        
        tempo = TestaVelocidadeColecoes.Contains(hashSet);
        System.out.println("HashSet: " + tempo + "ms");
        
        
        Collection<String> colecao = new HashSet<String>();
        colecao.add("estevam meneses");
        
        
        Iterator<String> iterator = colecao.iterator();
        
        for (String x : colecao) {// for in collection
            System.out.println(x.toUpperCase());
             System.out.println(iterator);
        }

        
        

    }

    @SuppressWarnings("unchecked")
	public static long AdicionaNoFinal(List lista) {
        long inicio = System.currentTimeMillis();
        int size = 100000;
        for (int i = 0; i < size; i++) {
            lista.add(i);
        }
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }
    
    @SuppressWarnings("unchecked")
	public static long Contains(Collection colecao) {
        
        int size = 100000;
        for (int i = 0; i < size; i++) {
            colecao.add(i);
            colecao.add("Estevam");
        }
        
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            colecao.contains(i);
        }
        
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

}
