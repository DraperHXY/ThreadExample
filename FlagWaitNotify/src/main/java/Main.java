/**
 * @author draper_hxy
 */
@SuppressWarnings("all")
public class Main {

    private static boolean flag = true;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread producerThread = new Thread(new Producer(lock, flag));
        Thread consumerThread = new Thread(new Consumer(lock, flag));
        producerThread.start();
        consumerThread.start();
    }
}
