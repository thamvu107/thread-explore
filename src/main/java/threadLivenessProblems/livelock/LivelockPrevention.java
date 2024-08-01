package threadLivenessProblems.livelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ThreadLocalRandom;

public class LivelockPrevention {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LivelockPrevention livelock = new LivelockPrevention();
        new Thread(livelock::operation1, "Thread-1").start();
        new Thread(livelock::operation2, "Thread-2").start();
    }

    public void operation1() {
        while (true) {
            if (lock1.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + "  acquired lock1, trying to acquire lock2.");
                    sleep(50); // Simulate the time required for business operation
                    if (lock2.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "  acquired lock2. Executing operation1.");
                            break;
                        } finally {
                            lock2.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "  unable to acquire lock2, releasing lock1.");
                    }
                } finally {
                    lock1.unlock();
                }
            }
            sleepRandom(); // Add random sleep to prevent livelock
        }
    }

    public void operation2() {
        while (true) {
            if (lock2.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2, trying to acquire lock1.");
                    sleep(50); // Simulate the time required for business operation
                    if (lock1.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "  acquired lock1. Executing operation2.");
                            break;
                        } finally {
                            lock1.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " unable to acquire lock1, releasing lock2.");
                    }
                } finally {
                    lock2.unlock();
                }
            }
            sleepRandom(); // Add random sleep to prevent livelock
        }
    }

    private void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleepRandom() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
