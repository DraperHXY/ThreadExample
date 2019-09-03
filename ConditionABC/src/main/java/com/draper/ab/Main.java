package com.draper.ab;

/**
 * @author draper_hxy
 */
public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        new Thread(new ARunnable(factory)).start();
        new Thread(new BRunnable(factory)).start();
    }

}
