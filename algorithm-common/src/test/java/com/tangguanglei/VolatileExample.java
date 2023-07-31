package com.tangguanglei;

class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
        if (v == true) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample v = new VolatileExample();
        Thread a = new Thread(() -> {
            v.writer();
        });
        Thread b = new Thread(() -> {
           v.reader();
        });
        a.start();
        b.start();
    }
}
