package com.draper;

import java.util.LinkedList;
import java.util.List;

/**
 * @author draper_hxy
 */
public class Main {

    public static void main(String[] args) {
        Object lock = new Object();
        List<String> list = new LinkedList<String>();
        Thread[] producerThreads = new Thread[5];
        for (int i = 0; i < producerThreads.length; i++) {
            producerThreads[i] = new Thread(new Producer(lock, list, 10));
            producerThreads[i].start();
        }
        Thread[] conumerThreads = new Thread[5];
        for (int i = 0; i < conumerThreads.length; i++) {
            conumerThreads[i] = new Thread(new Consumer(lock, list, 1));
            conumerThreads[i].start();
        }
    }
}
