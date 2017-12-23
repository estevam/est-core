/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.est.colection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
/**
 *
 * @author estevam
 */
public class SimpleSortComparator {
        /**
     * @param args the command line arguments
     */
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
         
        List<Date> myList = new ArrayList<Date>();
        myList.add(new Date(2015-1900, 01, 01));
        myList.add(new Date(2013-1900, 01, 01));
        myList.add(new Date(2013-1900, 01, 02));
        myList.add(new Date(2012-1900, 10, 01));
        myList.add(new Date(2012-1900, 11, 01));
        myList.add(new Date(2015-1900, 01, 10));
        myList.add(new Date(2012-1900, 01, 01));
        myList.add(new Date(2001-1900, 01, 01));
        
        System.out.println("Sem sort");
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i).toString());
        }
        
        Collections.sort(myList, new Comparator<Object>(){
 
            //@Override
            public int compare( Object o1, Object o2) {
                return 0; //o2.compareTo(o1); // mudar aqui a ordem
            }
        });
        
        System.out.println("Com sort");
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i).toString());
        }
 
    }
}
