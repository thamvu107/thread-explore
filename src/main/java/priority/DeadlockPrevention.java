package priority;

import threadLivenessProblems.deadlocks.demo2.Resource;
import utils.GeneralUtils;

public class DeadlockPrevention {
    public static void main(String[] args) {

        GeneralUtils.detectDeadlocks();

        Resource resource1 = new Resource("Ti To");
        Resource resource2 = new Resource("Teo Teo");

        Thread t1 = new Thread(() -> acquireLocks(resource1, resource2));
        Thread t2 = new Thread(() -> acquireLocks(resource2, resource1));

        t1.setName("T1");
        t2.setName("T2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }

    private static void acquireLocks(Resource resource1, Resource resource2) {
        Resource first = resource1.hashCode() < resource2.hashCode() ? resource1 : resource2;
        Resource second = resource1.hashCode() < resource2.hashCode() ? resource2 : resource1;

        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " locked " + first.getName());

            // Simulate some work with the first resource
            GeneralUtils.sleep(50);

            synchronized (second) {
                System.out.println(Thread.currentThread().getName() + " locked " + second.getName());
            }
        }
    }

}
