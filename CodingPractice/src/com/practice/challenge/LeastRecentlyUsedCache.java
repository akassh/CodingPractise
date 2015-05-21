package com.practice.challenge;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {
	private Map<Integer,Integer> cache;
    private final int capacity;
    public LeastRecentlyUsedCache(int capacity) {
        cache = new LinkedHashMap<Integer,Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
            return value; 
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(!cache.containsKey(key) && this.cache.size()==this.capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.remove(key);
        cache.put(key,value);
    }
}
