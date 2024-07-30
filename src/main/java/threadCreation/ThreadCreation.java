package threadCreation;

import utils.GeneralUtils;

public class ThreadCreation {
    public static void main(String[] args) {

        System.out.println("[1] Current thread: " + Thread.currentThread().getName());
        // 1. Extend the Thread class
        // 2. Use Runnable interface

        // 1. Extend the Thread class
        MyThreadExtendThread t1 = new MyThreadExtendThread();
        t1.start(); /// start and run new thread
//        myThread.run();// run thread( main thread) without creating new thread  =>
//        t1.join();
//        Thread.sleep(3000);
        System.out.println("[3] Current thread: " + t1.getName());

//        2. Runnable interface function
        Thread t2 = new Thread(new MyThreadImplementRunnable("ThreadRunnable"));
        t2.start();
//        t2.join();
        GeneralUtils.sleep(1000);
        System.out.println("[5] Current thread: " + t2.getName());

       // Anonymous new Runnable()
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("[6] Current thread: " + Thread.currentThread().getName());
            }
        };

        Thread t3  = new Thread(runnable1);
        t3.start();
//        t3.join();
        GeneralUtils.sleep(1000);
        System.out.println("[7] Current thread: " + t3.getName());

        // lambda
        Runnable runnable2 = () -> System.out.println("[8] Current thread: " + Thread.currentThread().getName());
        Thread t4 = new Thread(runnable2);
//        t4.setName("Thread4");
        t4.start();
//        t4.join();
        GeneralUtils.sleep(1000);
        System.out.println("[9] Current thread: " + Thread.currentThread().getName());
    }


}
