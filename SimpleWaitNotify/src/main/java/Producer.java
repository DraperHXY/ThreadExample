import java.util.List;

/**
 * @author draper_hxy
 */
class Producer implements Runnable {

    Object lock;
    List<String> list;

    Producer(Object lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    public void run() {
        while (true) {

            try {
                synchronized (lock) {
                    while (!list.isEmpty()) {
                        lock.wait();
                    }
                    list.add("生产");
                    System.out.println("生产");
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
