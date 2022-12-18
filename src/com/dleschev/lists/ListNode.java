package com.dleschev.lists;

import java.util.LinkedList;
import java.util.List;

/**
 * Single-linked list
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode listNode) {
        List<Integer> output = new LinkedList<>();
        while (listNode != null && listNode != listNode.next) {
            output.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("Output: " + output);
    }

}
