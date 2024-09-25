package com.tangguanglei.stack;

import java.util.Deque;
import java.util.LinkedList;

public class 最小栈155 {

    Deque<Integer> minStack;
    Deque<Integer> stack;

    public 最小栈155() {
        minStack = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
