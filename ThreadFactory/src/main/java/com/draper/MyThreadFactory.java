package com.draper;

import java.util.concurrent.ThreadFactory;

/**
 * @author draper_hxy
 */
public class MyThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("生产者");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t + "throw " + e);
            }
        });


        return thread;
    }

}
