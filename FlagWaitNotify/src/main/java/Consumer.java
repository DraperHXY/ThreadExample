/**
 * @author draper_hxy
 */
class Consumer implements Runnable {

    Object lock;
    Boolean flag;

    Consumer(Object lock, boolean flag) {
        this.lock = lock;
        this.flag = flag;
    }

    public void run() {
        while (true) {
            try {
                synchronized (lock) {
                    System.out.println(flag.toString());
                    while (flag) {
                        lock.wait();
                    }
                    System.out.println("消费");
                    flag = false;
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
