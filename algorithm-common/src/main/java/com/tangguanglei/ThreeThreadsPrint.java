package com.tangguanglei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadsPrint {

    private static Lock lock = new ReentrantLock();

    static class ThreadA extends Thread {
        @Override
        public void run() {

        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {

        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();;
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }
}
