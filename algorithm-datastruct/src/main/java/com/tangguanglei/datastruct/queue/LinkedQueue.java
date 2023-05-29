package com.tangguanglei.datastruct.queue;

import com.tangguanglei.datastruct.Node;

/**
 * 链式队列
 * @param <T>
 */
public class LinkedQueue<T> {
    private Node<T> head;

    private Node<T> tail;

    public LinkedQueue() {
        head = new Node<>();
        tail = head;
    }

    /**
     * 入队
     */
    public void enqueue(Node<T> node) {
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
    public Node<T> dequeue() {
        if (head.next == tail) {
            return null;
        }
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
}
