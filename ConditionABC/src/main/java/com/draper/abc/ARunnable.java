package com.draper.abc;

/**
 * @author draper_hxy
 */
public class ARunnable implements Runnable {

    Factory factory;

    ARunnable(Factory factory) {
        this.factory = factory;
    }

    public void run() {
        while (true) {
            factory.a();
        }
    }
}
