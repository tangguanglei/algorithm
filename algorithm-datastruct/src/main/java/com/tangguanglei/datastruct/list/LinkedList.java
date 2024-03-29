package com.tangguanglei.datastruct.list;

import com.tangguanglei.datastruct.ListNode;

/**
 * 单链表 https://juejin.cn/post/6844903584027377677
 */
public class LinkedList<T> {

    private final ListNode<T> head = new ListNode<>();

    /**
     * 添加数据
     * @param node
     */
    public void addNode(ListNode<T> node) {
        //临时节点
        ListNode<T> temp = head;
        //找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public ListNode<T> getNode(T data) {
        ListNode<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                return temp.next;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverse() {
        ListNode<T> temp = head.next;
        while (temp != null) {
            if (temp.data != null) {
                System.out.println("节点:" + temp.data);
            }
            temp = temp.next;
        }
    }

    public void insertNode(ListNode<T> node, int index) {
        if (index <= 0 || index > length()) {
            return;
        }
        ListNode<T> temp = head;
        int currentPos = 0;
        while (temp.next != null) {
            if ((index - 1) == currentPos) {
                node.next = temp.next;
                temp.next = node;
                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }

    public void deleteNode(int index) {
        if (index <= 0 || index > length()) {
            return;
        }
        ListNode<T> temp = head;
        int currentPos = 0;
        while (temp.next != null) {
            if ((index - 1) == currentPos) {
                ListNode<T> deleteNode = temp.next;
                temp.next = temp.next.next;
                deleteNode = null;
                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }

    public int length() {
        int length = 0;
        ListNode<T> temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
