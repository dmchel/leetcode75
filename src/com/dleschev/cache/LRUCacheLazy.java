package com.dleschev.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLazy implements IntegerCache {

    private final int maxSize;
    private final Map<Integer, Integer> cache;

    public LRUCacheLazy(int capacity) {
        this.maxSize = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > maxSize;
            }
        };
    }

    @Override
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    @Override
    public void put(int key, int value) {
        cache.put(key, value);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "cache=" + cache.entrySet() +
                ", capacity=" + maxSize +
                '}';
    }

}
