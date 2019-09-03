package com.draper.abc;

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
    private Condition c = lock.newCondition();

    public void a() {
        try {
            lock.lock();
            while (signal != 0) {
                a.await();
            }
            System.out.println("a");
            signal++;
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
            while (signal != 1) {
                b.await();
            }
            signal++;
            System.out.println("b");
            c.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void c() {
        try {
            lock.lock();
            while (signal != 2) {
                c.await();
            }
            signal = 0;
            System.out.println("c");
            a.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
