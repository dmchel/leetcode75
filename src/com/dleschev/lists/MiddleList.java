package com.dleschev.lists;

public class MiddleList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode.printList(list);
        ListNode middle = middleNode(list);
        ListNode.printList(middle);
    }

    public static ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int middle = len / 2;
        while (middle-- > 0) {
            head = head.next;
        }
        return head;
    }
}
