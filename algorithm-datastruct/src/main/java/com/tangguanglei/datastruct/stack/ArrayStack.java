package com.tangguanglei.datastruct.stack;

/**
 * 顺序栈
 */
public class ArrayStack {

    private Object[] item;

    private int size;

    private int top;

    public ArrayStack(int size) {
        item = new Object[size];
        this.size = size;
        this.top = 0;
    }

    public boolean push(Object data) {
        if (top == size) {
            return false;
        }
        item[top] = data;
        top++;
        return true;
    }

    public Object pop() {
        if (top < 1) {
            return null;
        }
        Object data = item[top - 1];
        top--;
        return data;
    }

    public Object peek() {
        if (top < 1) {
            return null;
        }
        return item[top - 1];
    }

    public boolean isEmpty() {
        return top < 1;
    }

    public boolean isFull() {
        return top == size;
    }

}
