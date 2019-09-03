import java.util.ArrayList;
import java.util.List;

/**
 * @author draper_hxy
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Object lock = new Object();
        List<String> list = new ArrayList<String>();

        Thread producerThread = new Thread(new Producer(lock, list));
        Thread consumerThread = new Thread(new Consumer(lock, list));

        producerThread.start();
        consumerThread.start();
    }
}
