package com.tangguanglei.linked;

import java.util.PriorityQueue;

public class 合并K个升序链表23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}
