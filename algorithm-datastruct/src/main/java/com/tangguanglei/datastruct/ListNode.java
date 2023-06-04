package com.tangguanglei.datastruct;

public class ListNode<T> {

    public T data;

    public ListNode<T> next;

    public ListNode<T> prev;

    public ListNode() {}

    public ListNode(T data) {
        this.data = data;
    }

    public ListNode(T data, ListNode<T> next, ListNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
