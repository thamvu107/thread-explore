package threadStates;

import utils.GeneralUtils;

public class BlockCase2 {
    private synchronized void businessProcessing() {
        try {
            System.out.println("Thread[" + Thread.currentThread().getName() + "] performs business processing " + Thread.currentThread().getState());
            Thread.sleep(2_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BlockCase2 blockCase = new BlockCase2();
        Thread A = new Thread(blockCase::businessProcessing, "A");
        Thread B = new Thread(blockCase::businessProcessing, "B");
        A.start();
        GeneralUtils.sleep(500L); // A state should be TIMED_WAITING
        B.start();
        System.out.println("Thread[" + A.getName() + "] state:" + A.getState());
        System.out.println("Thread[" + B.getName() + "] state:" + B.getState());

        // NOTE: Different CPU competition results will lead to different output results.

        // If the CPU execution efficiency is a little lower than the business processing time, the output will be:
//        Thread[A] performs business processing
//        Thread[A] state:TIMED_WAITING
//        Thread[B] state:BLOCKED
//        Thread[B] performs business processing

//        The state transition process of thread A:：
//        NEW -> RUNNABLE（ A.start() ） -> TIMED_WATING（ Thread.sleep() ）-> RUNABLE（ sleep() time is up ） -> TERMINATED
//        The state transition process of thread B：
//        NEW -> RUNNABLE（B.start()) -> **BLOCKED ( Didn't grab the lock )** -> RUNNABLE ( A releases the lock ) -> TIMED_WATING（ Thread.sleep() ）-> RUNABLE（ sleep() time is up ）-> TERMINATED

    }

}
