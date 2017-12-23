package com.est.cache;


import java.util.*;
/**
 * 
 * @author estevam
 *
 */
public class CacheManagerObject {

    private static CacheManagerObject instance;
    private static Object monitor = new Object();
    private Map<String, Object> cache = Collections.synchronizedMap(new HashMap<String, Object>());

    private CacheManagerObject() {
    }
    
    public static CacheManagerObject getInstance() {
        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new CacheManagerObject();
                }
            }
        }
        return instance;
    }

    public void put(String cacheKey, Object value) {
        cache.put(cacheKey, value);
    }

    public Object get(String cacheKey) {
        return cache.get(cacheKey);
    }

    public void clear(String cacheKey) {
        cache.put(cacheKey, null);
    }

    public void clear() {
        cache.clear();
    }

}