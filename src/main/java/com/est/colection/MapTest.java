/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author estevam
 */
@SuppressWarnings("unchecked")
public class MapTest {

    private Map<Integer, String> iControlParentInt;
    private HashMap<String, String> iControlParentStr;

    public void loadMap() {

        // LinkedHashMap coloca a lista em ordem numeria usando key 
        iControlParentInt = new LinkedHashMap<Integer, String>();
        iControlParentInt.put(0, "test1");
        iControlParentInt.put(1, "test2");
        iControlParentInt.put(2, "test3");
        iControlParentInt.put(3, "test4");
        iControlParentInt.put(4, "test6");
        iControlParentInt.put(5, "test8");
        iControlParentInt.put(6, "test9");

        // HashMap nao coloca a lisa em ordem numerica
        iControlParentStr = new HashMap<String, String>();
        iControlParentStr.put("0", "test1");
        iControlParentStr.put("1", "test4");
        iControlParentStr.put("5", "test8");
        iControlParentStr.put("3", "test5");
        iControlParentStr.put("6", "test3");
        iControlParentStr.put("2", "test2");
        iControlParentStr.put("4", "test0");


        // loop 
        Iterator<?> it = iControlParentInt.entrySet().iterator();
        while (it.hasNext()) {
          
			Map.Entry<Integer, String> pairs = (Entry<Integer, String>) it.next();
            System.out.println("Key: " + pairs.getKey() + "Rating: " + pairs.setValue(null));

        }

    }
}
