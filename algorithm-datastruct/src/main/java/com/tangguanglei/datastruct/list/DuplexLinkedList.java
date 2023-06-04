package com.tangguanglei.datastruct.list;

import com.tangguanglei.datastruct.ListNode;

/**
 * 双向链表
 */
public class DuplexLinkedList<T> {

    private final ListNode<T> head = new ListNode<>();

    public void addNode(ListNode<T> node) {
        //临时节点
        ListNode<T> temp = head;
        //找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }
}
