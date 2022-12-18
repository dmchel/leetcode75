package com.dleschev.lists;

import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printList(list);
        printList(reverse(list));
        list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printList(reverseLoop(list));
    }

    public static void printList(ListNode listNode) {
        List<Integer> output = new LinkedList<>();
        while (listNode != null && listNode != listNode.next) {
            output.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("Output: " + output);
    }

    public static ListNode reverseLoop(ListNode list) {
        if (list == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = list;
        ListNode next = list.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public static ListNode reverse(ListNode list) {
        if (list == null) {
            return null;
        }
        return doReverse(null, list, list.next);
    }

    public static ListNode doReverse(ListNode prev, ListNode curr, ListNode next) {
        if (curr == null) {
            return prev;
        }
        curr.next = prev;
        prev = curr;
        curr = next;
        if (next != null) {
            next = next.next;
        }
        return doReverse(prev, curr, next);
    }

}
