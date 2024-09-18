package com.tangguanglei.linked;

import java.util.HashMap;
import java.util.Map;

public class LRU缓存146 {

    private Map<Integer, DLinkedNode> map = new HashMap<>();

    private int size;

    private int capacity;

    private DLinkedNode head, tail;

    public LRU缓存146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            map.put(key, node);
            add2Head(node);
            size++;
            if (size > capacity) {
                node = removeTail();
                map.remove(node.key);
            }
        } else {
            node.value = value;
            move2Head(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }

    private void add2Head(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void move2Head(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        add2Head(node);
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    private class DLinkedNode{

        private int key;

        private int value;

        private DLinkedNode prev;

        private DLinkedNode next;

        DLinkedNode() {}

        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
