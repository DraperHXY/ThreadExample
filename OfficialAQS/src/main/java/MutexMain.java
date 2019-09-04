/**
 * @author draper_hxy
 */
public class MutexMain {
    private static int i = 0;

    public static void main(String[] args) {
        Mutex mutex = new Mutex();

        Thread[] threads = new Thread[10];
        for (int j = 0; j < threads.length; j++) {
            threads[j] = new Thread((() -> {
                for (int k = 0; k < 10000; k++) {
                    mutex.lock();
                    i++;
                    mutex.unlock();
                }

            }));
            threads[j].start();
        }
        for (int i1 = 0; i1 < threads.length; i1++) {
            try {
                threads[i1].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i);

    }

}
