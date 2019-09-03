import java.util.List;

/**
 * @author draper_hxy
 */
class Consumer implements Runnable {

    Object lock;
    List<String> list;

    Consumer(Object lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    public void run() {
        while (true) {
            try {
                synchronized (lock) {
                    while (list.isEmpty()) {
                        lock.wait();
                    }
                    list.clear();
                    System.out.println("消费");
                    lock.notifyAll();;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
