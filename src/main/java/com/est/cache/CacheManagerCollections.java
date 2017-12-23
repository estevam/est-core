
package com.est.cache;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author estevam
 */
public class CacheManagerCollections {

    private static CacheManagerCollections instance;
    private static Object monitor = new Object();
    private Map<String, Collection<Object>> cache = Collections.synchronizedMap(new HashMap<String, Collection<Object>>());

    public static CacheManagerCollections getInstance() {
        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new CacheManagerCollections();
                }
            }
        }
        return instance;
    }
    
    
    /**
     * Add cache for any type
     */
    private CacheManagerCollections() {
    }

    public void put(String cacheKey, Collection<Object> value) {
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
