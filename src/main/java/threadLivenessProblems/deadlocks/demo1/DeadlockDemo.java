package threadLivenessProblems.deadlocks.demo1;

import utils.GeneralUtils;

public class DeadlockDemo {
    public static void main(String[] args) {

        GeneralUtils.detectDeadlocks();

        Resource resource1 = new Resource("Resource1");
        Resource resource2 = new Resource("Resource2");

        Thread thread1 = new Thread(() -> resource1.method1(resource2));
        Thread thread2 = new Thread(() -> resource2.method1(resource1));

        thread1.start();
        thread2.start();
    }
}
