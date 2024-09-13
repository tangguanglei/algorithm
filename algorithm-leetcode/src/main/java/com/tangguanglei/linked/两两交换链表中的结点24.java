package com.tangguanglei.linked;

public class 两两交换链表中的结点24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            node1.next = node2.next;
            node2.next = node1;
            temp.next = node2;
            temp = node1;
        }
        return dummy.next;
    }
}
