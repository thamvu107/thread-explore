package stopThread.demo1;

import utils.GeneralUtils;

public class StoppableDemo {
    public static void main(String[] args) {
        StoppableRunnable runnable1 = new StoppableRunnable();
        StoppableRunnable runnable2 = new StoppableRunnable();

        Thread t1 = new Thread(runnable1, "Thread1");
        Thread t2 = new Thread(runnable1, "Thread2");
        Thread t3 = new Thread(runnable2, "Thread3");

        t1.start();
        t2.start();
        t3.start();

        GeneralUtils.sleep(5_000); // make main thread sleep for 1 second

        System.out.println("Requesting stop runnable1");
        runnable1.requestStopped();
        System.out.println("Stop runnable1 requested sent");

        GeneralUtils.sleep(5_000); // make main thread sleep for 1 second

        System.out.println("Requesting stop runnable2");
        runnable2.requestStopped();
        System.out.println("Stop runnable2 requested sent");
    }

}
