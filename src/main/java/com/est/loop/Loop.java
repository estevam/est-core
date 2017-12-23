/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.loop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author estevam
 */
public class Loop {

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]) {

        List<String> strList = new ArrayList<>();

        // using for-each
        for (String obj : strList) {
            System.out.println(obj);
        }

        //using itaretor
        Iterator<String> it = strList.iterator();

        while (it.hasNext()) {
            String obj = it.next();
            System.out.println(obj);
        }


        // itarator remove item

//        
//        for (Iterator<Friend> itr = iFriendsList.iterator(); itr.hasNext();) {
//                String element = itr.next().getUid();
//                if (!element.equals(iFriendUid)) {
//                    itr.remove();
//                }
//        }                

        // loop itarator in HASH MAP
        HashMap<Integer, String> iControlParentInt = new HashMap<Integer, String>();
        iControlParentInt.put(0, "estevam");
        iControlParentInt.put(1, "ivo");


        Iterator<?> itHashMap = iControlParentInt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> pairs = (Map.Entry) itHashMap.next();
            if (pairs.getKey() == 0) {
                System.out.println(pairs.getValue());
                break;
            }
        }

    }
}
