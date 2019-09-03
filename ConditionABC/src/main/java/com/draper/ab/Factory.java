package com.draper.ab;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author draper_hxy
 */
public class Factory {

    private static int signal = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();

    public void a() {
        try {

            lock.lock();
            while (signal == 1) {
                a.await();
            }
            signal++;
            System.out.println("a");
            b.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void b() {
        try {
            lock.lock();
            while (signal == 0) {
                b.await();
            }
            signal--;
            System.out.println("b");
            a.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
