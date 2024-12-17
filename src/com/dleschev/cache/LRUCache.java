package com.dleschev.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Least Recently Used (LRU) cache implementation
 */
public class LRUCache implements IntegerCache {

    private static class Node {
        private final int key;
        private int value;
        private Node next;
        private Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node() {
            this(0, 0);
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }

    @Override
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        } else {
            node.value = value;
            update(node);
        }
        if (cache.size() > capacity) {
            Node toDelete = tail.prev;
            remove(toDelete);
            cache.remove(toDelete.key);
        }

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "cache=" + cache.entrySet() +
                ", capacity=" + capacity +
                '}';
    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    private void add(Node node) {
        Node after = head.next;     // the most recently added element (before this method call)
        head.next = node;           // head now points to the new most recent element
        node.prev = head;           // attach the new node to head
        node.next = after;          // attach the new node to the "after" element
        after.prev = node;          // attach the "after" element to the new node
    }

    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

}
