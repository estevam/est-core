/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

import java.util.*;


/**
 *commons-codec-1.2.jar
 * @author estevam
 */
public class UtilitarioCollections {

    /*
     * Java Collection (List,Set, Queue, Map) List - Implementa Vector,
     * ArrayList e LinkedList - tipo ordenado Set - Implementa
     * HashSet,LinkedHashSet, TreeSet - tipo sem duplicatas Queue - Implementa
     * LinkedList e ProrityQueue Map -- HashMap, HashTable,
     * TreeMap,LinkedHashMap
     */
	
    public static void main(String args[]) {

        TrabalhandoComList();  // List permite duplicacoes, dados repetidos na lista
       // TrabalhandoComSet(); // Set nao permite tipo repitido na lista
        //TrabalhandoComQueue();// fila de espera
        //  TrabalhandoComMap(); // associan chaves a valores - chaves unicas -  volores pode ser duplicados
    }

    public static void TrabalhandoComList() {

    	String test[] ={"aaa", "bbb"};
        List<String> frutas = new ArrayList<String>();
        frutas.addAll(Arrays.asList(test));
        
        frutas.add("coco");
        frutas.add("manga");
        frutas.add("caju");
        frutas.add("banana");

        System.out.println(frutas);

        Collections.sort(frutas); // sort - lista em ordem alfabetica 
        System.out.println(frutas);

        Collections.reverse(frutas); // reverse - lista em ordem envertida 
        System.out.println(frutas);

        Collections.shuffle(frutas); // shuffle - embaralhar a lista
        System.out.println(frutas);

        Collections.addAll(frutas, "pitanga", "caju"); // add all - adicionar a lista
        System.out.println(frutas);

        //frequency - mostra quantas vezes item se repete na lista
        System.out.println("frequency=>"+Collections.frequency(frutas, "caju"));

        // desjoin -  checar se elemento da lista esta em outra lista
        List<String> frutas2 = Arrays.asList("pitanga", "banana");
        boolean item = Collections.disjoint(frutas, frutas2);
        System.out.println("disjoint:" +item);

        // procurar indice interiro da lista 
        Collections.sort(frutas);
        int indice = Collections.binarySearch(frutas, "manga");
        System.out.println("Indice  binarySearch:" + indice);

        // fill - vai mudar todos os itens da colecao paro o especificado
        Collections.fill(frutas, "manga");
        System.out.println("fill : " +frutas);

        // constante para proibir que a lista seja alterada
        Collections.unmodifiableCollection(frutas);


        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(new Integer("3"));
        arrayList.add(new Integer("1"));
        arrayList.add(new Integer("8"));
        arrayList.add(new Integer("3"));
        arrayList.add(new Integer("5"));
 
        Object obj = Collections.max(arrayList); // retorna o maximo inteiro
        System.out.println(obj);
        Object obj2 = Collections.min(arrayList);  // retorna o manimo inteiro
        System.out.println(obj2);
    }

    static void TrabalhandoComSet() {

        String[] cores = {"verde", "amarelo", "azul", "branco",
            "verde", "amarelo", "azul", "branco"};

        List<String> list = Arrays.asList(cores); // tipo List perte itens repitidos
        System.out.println(list);

        Set<String> set = new HashSet<String>(list);
        System.out.println(set);
    }

    static void TrabalhandoComQueue() {
        // fila de espera - primeiro a entrar eh o primeiro a sair
        Queue<String> fila = new LinkedList<String>();
        fila.add("Estevam");
        fila.add("Ivo");
        fila.add("Ilse");
        fila.add("Debora");
        System.out.println(fila);
        System.out.println(fila.peek()); // vai procurar o primeiro elemento que
        // foi adicionado
        // Exemplo real: Sistema de atendimento

        System.out.println(fila.poll()); // vai remover  o primeiro intem que 
        // foi adicionado
        System.out.println(fila);

        LinkedList<String> fila2 = new LinkedList<String>(fila);
        fila2.addFirst("Maria");// adiciona elemento a primeiro da lista
        fila2.addLast("Robet"); // adiciona elemento ultimo da lista 
        System.out.println(fila2);

        System.out.println(fila2.peekFirst());
        System.out.println(fila2.peekLast());
        // System.out.println(fila2.pollFirst()); 
        // System.out.println(fila2.pollLast());
    }

    static void TrabalhandoComMap() {
        Map<String, String> pais = new HashMap<String, String>();
        pais.put("BR", "Brasil");
        pais.put("RU", "Russia");
        pais.put("IN", "India");
        pais.put("CN", "China");

        System.out.println(pais);
        System.out.println("containsKey :" + pais.containsKey("BR"));
        System.out.println("containsValue :" + pais.containsValue("Brasil"));
        System.out.println("get value usando key :" + pais.get("BR"));
        pais.remove("RU");
        
        Set<String> keys = pais.keySet();
      
        for (String k: keys){
                System.out.println(k +" : " + pais.get(k));
        }

    }
    
    
    static void TrabalhandoComMap2() {
        Map<String, List<Object>> pais = new HashMap<String, List<Object>>();
        
        List<Object> lObj = new ArrayList<Object>();
        lObj.add(0);
        
        pais.put("BR", lObj);

        System.out.println(pais);
        System.out.println("containsKey :" + pais.containsKey("BR"));
        //System.out.println("containsValue :" + pais.containsValue("Brasil"));
        System.out.println("get value usando key :" + pais.get("BR"));
        pais.remove("RU");
        
        Set<String> keys = pais.keySet();
      
        for (String k: keys){
                System.out.println(k +" : " + pais.get(k));
        }

    }
}
