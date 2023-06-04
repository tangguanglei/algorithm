package com.tangguanglei.datastruct.queue;

import com.tangguanglei.datastruct.ListNode;

/**
 * 链式队列
 * @param <T>
 */
public class LinkedQueue<T> {
    private ListNode<T> head;

    private ListNode<T> tail;

    public LinkedQueue() {
        head = new ListNode<>();
        tail = head;
    }

    /**
     * 入队
     */
    public void enqueue(ListNode<T> node) {
        if (node == null) {
            return;
        }
        tail.next = node;
        tail = node;
    }

    /**
     * 出队
     * @return
     */
    public ListNode<T> dequeue() {
        if (head.next == tail) {
            return null;
        }
        ListNode<T> temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
}
