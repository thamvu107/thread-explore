package threadLivenessProblems.deadlocks.demo2;

import utils.GeneralUtils;

public class DeadlockPrevention {
    public static void main(String[] args) {

        GeneralUtils.detectDeadlocks();

        Resource resource1 = new Resource("Ti To");
        Resource resource2 = new Resource("Teo Teo");

        Thread thread1 = new Thread(() -> acquireLocks(resource1, resource2));
        Thread thread2 = new Thread(() -> acquireLocks(resource2, resource1));

        thread1.start();
        thread2.start();
    }

    private static void acquireLocks(Resource resource1, Resource resource2) {
        Resource first = resource1.hashCode() < resource2.hashCode() ? resource1 : resource2;
        Resource second = resource1.hashCode() < resource2.hashCode() ? resource2 : resource1;

        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " locked " + first.getName());

            // Simulate some work with the first resource
            sleep(50);

            synchronized (second) {
                System.out.println(Thread.currentThread().getName() + " locked " + second.getName());
            }
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
}
