package com.tangguanglei.linked;

public class 回文链表234 {

    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        int jump = 0;
        if (len % 2 == 0) {
            jump = len / 2;
        } else {
            jump = len / 2 + 1;
        }
        for (int i = 0; i < jump; i++) {
            p = p.next;
        }
        p = reverse(p);
        while (p != null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
