package com.tangguanglei.heap;

import java.util.PriorityQueue;

public class 数据流的中位数295 {

    PriorityQueue<Integer> minQ;

    PriorityQueue<Integer> maxQ;

    public 数据流的中位数295() {
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minQ.isEmpty() || num < minQ.peek()) {
            minQ.offer(num);
            if (maxQ.size() + 1 < minQ.size()) {
                maxQ.offer(minQ.poll());
            }
        } else {
            maxQ.offer(num);
            if (minQ.size() < maxQ.size()) {
                minQ.offer(maxQ.poll());
            }
        }
    }

    public double findMedian() {
        if (minQ.size() > maxQ.size()) {
            return minQ.peek();
        }
        return (minQ.peek() + maxQ.peek()) / 2.0;
    }
}
