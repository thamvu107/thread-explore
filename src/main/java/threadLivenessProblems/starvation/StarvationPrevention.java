package threadLivenessProblems.starvation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StarvationPrevention {
    private static final Lock lock = new ReentrantLock(true); // Fair lock

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task(), "Thread-1");
        Thread t2 = new Thread(new Task(), "Thread-2");

        t1.setPriority(Thread.MIN_PRIORITY); // Low priority
        t2.setPriority(Thread.MAX_PRIORITY); // High priority

        t1.start();
        t2.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                    // Simulate some work with a short sleep
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " released the lock.");
                }
                // Sleep to allow other threads a chance to acquire the lock
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
