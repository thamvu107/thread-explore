package threadCreation;

import utils.GeneralUtils;

public class MyThreadImplementRunnable implements Runnable{
    private String name;
    public MyThreadImplementRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("[4] Current Thread: " + thread.getName());
        for (int i = 1; i <= 5; i++) {
            GeneralUtils.sleep(1_000);
            System.out.println("Wake up: " + thread.getName() + " priority: " + thread.getPriority() + " value: " + i);
        }

    }
}
