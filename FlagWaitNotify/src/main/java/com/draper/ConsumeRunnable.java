package com.draper;

/**
 * @author draper_hxy
 */
public class ConsumeRunnable implements Runnable {

    Factory factory;

    ConsumeRunnable(Factory factory) {
        this.factory = factory;
    }

    public void run() {
        while (true){
            factory.consume();
        }
    }
}
