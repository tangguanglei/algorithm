package com.tangguanglei.datastruct.link;

import com.tangguanglei.datastruct.Node;

/**
 * 双向链表
 */
public class DuplexLinkedList<T> {

    private final Node<T> head = new Node<>();

    public void addNode(Node<T> node) {
        //临时节点
        Node<T> temp = head;
        //找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }
}
