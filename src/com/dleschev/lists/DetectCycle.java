package com.dleschev.lists;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        list.next.next.next.next = list.next;
        ListNode cycleStart = detectCycle(list);
        System.out.println(cycleStart != null ? cycleStart.val : null);
    }

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return null;
    }
}
