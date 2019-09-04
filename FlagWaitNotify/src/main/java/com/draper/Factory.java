package com.draper;


/**
 * @author draper_hxy
 */
@SuppressWarnings("all")
public class Factory {

    private Object lock = new Object();
    private boolean flag = true;

    public void produce() {
        try {
            synchronized (lock) {
                while (!flag) {
                    lock.wait();
                }
                System.out.println("生产");
                flag = false;
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() {
        try {
            synchronized (lock) {
                while (flag) {
                    lock.wait();
                }
                System.out.println("消费");
                flag = true;
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
