package threadCreation;

import utils.GeneralUtils;

public class MyThreadExtendThread extends Thread {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
//        setName("Thread1");
        System.out.println("[2] Current thread: " + thread.getName());
        GeneralUtils.sleep(3_000);

    }
}
