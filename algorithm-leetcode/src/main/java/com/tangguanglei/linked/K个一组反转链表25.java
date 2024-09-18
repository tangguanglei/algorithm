package com.tangguanglei.linked;

public class K个一组反转链表25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, end = dummy;
        while (prev.next != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummy.next;
                }
            }
            ListNode start = prev.next;
            ListNode post = end.next;
            end.next = null;
            reverse(start);
            prev.next = end;
            start.next = post;
            prev = start;
            end = start;
        }
        return dummy.next;
    }

    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
}
