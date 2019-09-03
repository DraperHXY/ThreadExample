package com.draper;

import java.util.List;

/**
 * @author draper_hxy
 */
class Consumer implements Runnable {
    Object lock;
    List<String> list;
    int size;

    Consumer(Object lock, List<String> list, int size) {
        this.lock = lock;
        this.list = list;
        this.size = size;
    }

    public void run() {
        synchronized (lock) {
            try {
                while (true) {
                    while (list.size() < size) {
                        lock.wait();
                    }
                    list.remove(list.size() - 1);
                    System.out.println(Thread.currentThread().getName() + "消费至" + list.size());
                    Thread.sleep(1000L);
                    lock.notifyAll();
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
