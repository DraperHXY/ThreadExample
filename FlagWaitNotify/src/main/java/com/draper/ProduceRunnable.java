package com.draper;

/**
 * @author draper_hxy
 */
public class ProduceRunnable implements Runnable {
    Factory factory;

    ProduceRunnable(Factory factory) {
        this.factory = factory;
    }

    public void run() {
        while (true) {
            factory.produce();
        }
    }
}
