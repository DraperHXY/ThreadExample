package com.draper;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author draper_hxy
 */
public class Main {

    public static void main1(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new MyThreadFactory());
        executor.submit(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "...");
                    Random random = new Random();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (random.nextInt(5) % 2 == 0) {
                        System.err.println("抛出异常");
                        throw new RuntimeException("fuck");
                    }

                }
            }
        });
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                throw new RuntimeException("我是异常");
            }
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("捕获成功");
            }
        });
        thread.start();
    }

}
