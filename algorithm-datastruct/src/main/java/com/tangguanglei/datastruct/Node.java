package com.tangguanglei.datastruct;

import lombok.Data;

@Data
public class Node {

    private Object data;

    private Node next;

    private Node prev;

    public Node(Object data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
