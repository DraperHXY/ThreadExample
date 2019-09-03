package com.draper.ab;

/**
 * @author draper_hxy
 */
public class BRunnable implements Runnable {
    Factory factory;

    BRunnable(Factory factory) {
        this.factory = factory;
    }

    public void run() {
        while (true){
            factory.b();
        }
    }
}
