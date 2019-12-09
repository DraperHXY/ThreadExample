package com.draper;

/**
 * @author draper_hxy
 */
public class First {

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public static void main(String[] args) {
        threadId.set(333);

        new Thread(new Runnable() {
            public void run() {
                threadId.set(33);
                System.out.println(threadId.get());
                threadId.remove();
                System.out.println(threadId.get());
            }
        }).start();
    }




}
