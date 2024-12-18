package com.dleschev.cache;

import java.util.HashMap;
import java.util.Map;

/**
 *  Least Frequently Used (LFU) cache implementation
 */
public class LFUCache implements IntegerCache {

    private static class Node {
        private final int key;
        private int value;
        private int counter;
        private Node next;
        private Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            counter = 1;
        }

        Node() {
            this(0, 0);
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private static class NodeList {
        private final Node head;
        private final Node tail;

        NodeList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        boolean isEmpty() {
            return head.next == tail && tail.prev == head;
        }

    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Map<Integer, NodeList> frequencyMap;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.frequencyMap = new HashMap<>();
        minFrequency = 1;
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
            if (cache.size() == capacity) {
                Node toDelete = frequencyMap.get(minFrequency).tail.prev;
                remove(toDelete);
                cache.remove(toDelete.key);
            }
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
            minFrequency = 1;
        } else {
            node.value = value;
            update(node);
        }
    }

    @Override
    public String toString() {
        return "LFUCache{" +
                "cache=" + cache.entrySet() +
                ", capacity=" + capacity +
                '}';
    }

    private void update(Node node) {
        remove(node);
        node.counter++;
        add(node);
    }

    private void add(Node node) {
        frequencyMap.putIfAbsent(node.counter, new NodeList());
        NodeList frequencyList = frequencyMap.get(node.counter);
        Node head = frequencyList.head;
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
        NodeList frequencyList = frequencyMap.get(node.counter);
        if (frequencyList != null && frequencyList.isEmpty()) {
            frequencyMap.remove(node.counter);
            if (minFrequency == node.counter) {
                minFrequency++;
            }
        }
    }

}
