package com.draper;

import java.util.List;

/**
 * @author draper_hxy
 */
class Producer implements Runnable {

    List<String> list;
    Object lock;
    int size;

    Producer(Object lock, List<String> list, int size) {
        this.lock = lock;
        this.list = list;
        this.size = size;
    }

    public void run() {

        synchronized (lock) {
            try {
                while (true) {
                    while (list.size() == size) {
                        lock.wait();
                    }
                    list.add(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getName() + "生产至" + list.size());
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
