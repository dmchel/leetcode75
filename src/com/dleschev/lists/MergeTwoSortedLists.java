package com.dleschev.lists;

import java.util.LinkedList;
import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        list1.next = list1;
        ListNode list2 = new ListNode();
        list2.next = list2;

        printList(mergeTwoLists(list1, list2));

        list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        printList(list1);
        printList(list2);

        printList(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // TODO simplify me
        ListNode current = new ListNode();
        current.next = current;
        final ListNode result = current;
        while (list1 != null || list2 != null) {
            if (list1 == null || list1.next == list1) {
                current.next = list2;
                break;
            } else if (list2 == null || list2.next == list2) {
                current.next = list1;
                break;
            } else {
                if (list1.val < list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                    current = current.next;
                } else if (list1.val > list2.val) {
                    current.next = list2;
                    list2 = list2.next;
                    current = current.next;
                } else {
                    current.next = list1;
                    list1 = list1.next;
                    current = current.next;
                    current.next = list2;
                    list2 = list2.next;
                    current = current.next;
                }
            }
        }
        return result.next != result ? result.next : null;
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
