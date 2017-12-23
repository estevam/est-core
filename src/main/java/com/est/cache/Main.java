
package com.est.cache;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author estevam
 */
public class Main {
    public static void main(String[] args) {
        
    }
    
    public  void testManagerCollection(){
        
        
        LinkedList<Object> a = new LinkedList<Object>();
        List<Object> friends = new ArrayList<Object>();
        
        CacheManagerCollections.getInstance().put("ListOfFriends",a);
        CacheManagerCollections.getInstance().put("ListOfFriends",friends);
    }
}
