package threadStates;

import utils.GeneralUtils;

public class WaitingCase {
    private synchronized void businessProcessing() {
        System.out.println("Thread[" + Thread.currentThread().getName() + "] expects to process business, but the computer is broken");
        // Release the monitor(lock)
        try {
            wait();

            // business processing
            System.out.println("Thread[" + Thread.currentThread().getName() + "] continues to process business");
            Thread.sleep(2_000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void repairComputer() {
        System.out.println("Thread[" + Thread.currentThread().getName() + "] comes to repair the computer");
        // Simulated Repair
        GeneralUtils.sleep(2_000L);
        System.out.println("Thread[" + Thread.currentThread().getName() + "] has completed the repair.");
        notify();
    }

    public static void main(String[] args) {
        WaitingCase blockedCase = new WaitingCase();
        Thread t1 = new Thread(blockedCase::businessProcessing, "T1");
        Thread t2 = new Thread(blockedCase::repairComputer, "T2");

        t1.start();
        GeneralUtils.sleep(500L); //Used to ensure that thread A grabs the lock first. Sleep time should be less than repair time

        t2.start();
        // Wait for a moment to ensure the threads have started and the states have transitioned

        System.out.println("Thread[" + t1.getName() + "] state:" + t1.getState());
        System.out.println("Thread[" + t2.getName() + "] state:" + t2.getState());

        // Wait for the threads to finish execution to print final state
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread[" + t1.getName() + "] final state: " + t1.getState());
        System.out.println("Thread[" + t2.getName() + "] final state: " + t2.getState());
    }
}
