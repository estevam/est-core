/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

/**
 *
 * @author estevam
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class USport {
List<String> a= new ArrayList<String>();
    String school;
    String name;

    public USport(String s, String n) {
        school = s;
        name = n;
    }

    public String toString() {
        return school + ":" + name;
    }
}

public class TestaColecoes {

    public static void main(String a[]) {
    	testList();
        ArrayList<USport> v = new ArrayList<USport>();
        
        v.add(new USport("Dal", "Tigers"));
        v.add(new USport("SMU", "Huskies"));
        v.add(new USport("Acadia", "Axemen"));
        
        System.out.println(v); // uses ArrayList.toString() & USport.toString()
        for (int i = v.size() - 1; i >= 0; i--) {
            USport us = v.get(i);
            System.out.print(us.school + " ");
        }
        System.out.println();
        for (USport us : v) // java 1.5 for loop
        {
            System.out.print(us.school + " ");
        }
        System.out.println();
        while (v.size() > 0) {
            USport us = v.remove(0); // expensive!
            System.out.print(us.name + " ");
        }
        System.out.println();
        
        
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    arrayList.add(3);
    arrayList.add(1);
    arrayList.add(8);
    arrayList.add(3);
    arrayList.add(5);

    Object obj = Collections.max(arrayList);
    System.out.println(obj);
        
    }
    
    
    public static <T>  List<Object> testList(){
    	
    	List<Object> l = new ArrayList<Object>();
    	l.add("a");
    	l.add(1);
    	
    	for(int a= 0; a< l.size(); a++){
    		System.out.println(l.get(a));
    	}
    	
    	return l;
    }
}


