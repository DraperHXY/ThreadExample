/**
 * @author draper_hxy
 */
class Producer implements Runnable {

    Object lock;
    boolean flag;

    Producer(Object lock, boolean flag) {
        this.lock = lock;
        this.flag = flag;
    }

    public void run() {
        while (true) {
            try {
                synchronized (lock) {
                    while (!flag) {
                        lock.wait();
                    }
                    System.out.println("生产");
                    flag = false;
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
