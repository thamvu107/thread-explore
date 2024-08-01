package priority;

import threadLivenessProblems.deadlocks.demo2.Resource;
import utils.GeneralUtils;

public class DeadlockDemo {
    public static void main(String[] args) {

        GeneralUtils.detectDeadlocks();

        Resource resource1 = new Resource("Resource1");
        Resource resource2 = new Resource("Resource2");

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {

                System.out.println(Thread.currentThread().getName() + " locked " + resource1.getName());
                // Simulate some work with resource1
                GeneralUtils.sleep(50);
                System.out.println(Thread.currentThread().getName() + " trying to lock " + resource2.getName());

                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource2.getName());
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {

                System.out.println(Thread.currentThread().getName() + " locked " + resource2.getName());
                // Simulate some work with resource2
                GeneralUtils.sleep(50);
                System.out.println(Thread.currentThread().getName() + " trying to lock " + resource1.getName());

                synchronized (resource1) {

                    System.out.println(Thread.currentThread().getName() + " locked " + resource1.getName());
                }
            }
        });

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }



}
