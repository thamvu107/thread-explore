package deadlocks.demo1;

import deadlocks.demo1.Resource;

public class DeadlockDemo {
    public static void main(String[] args) {
        Resource resource1 = new Resource("Resource1");
        Resource resource2 = new Resource("Resource2");

        Thread thread1 = new Thread(() -> resource1.method1(resource2));
        Thread thread2 = new Thread(() -> resource2.method1(resource1));

        thread1.start();
        thread2.start();
    }
}
