package com.draper.abc;

/**
 * @author draper_hxy
 */
public class CRunnable implements Runnable {

    Factory factory;

    CRunnable(Factory factory) {
        this.factory = factory;
    }

    public void run() {
        while (true) {
            factory.c();
        }
    }
}
