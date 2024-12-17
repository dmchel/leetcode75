package com.dleschev.cache;

public interface IntegerCache {

    int get(int key);
    void put(int key, int value);

}
