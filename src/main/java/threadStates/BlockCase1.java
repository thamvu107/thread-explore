package threadStates;

public class BlockCase1 {
    private synchronized void businessProcessing() {
        try {
            System.out.println("Thread[" + Thread.currentThread().getName() + "] performs business processing " + Thread.currentThread().getState());
            Thread.sleep(2_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BlockCase1 blockCase = new BlockCase1();
        Thread A = new Thread(blockCase::businessProcessing, "A");
        Thread B = new Thread(blockCase::businessProcessing, "B");
        A.start();
        B.start();
        System.out.println("Thread[" + A.getName() + "] state:" + A.getState());
        System.out.println("Thread[" + B.getName() + "] state:" + B.getState());

        // NOTE: Different CPU competition results will lead to different output results.

        // If the CPU execution efficiency is a little lower than the business processing time, the output will be:
//        Thread[A] performs business processing
//        Thread[A] state:TIMED_WAITING
//        Thread[B] state:BLOCKED
//        Thread[B] performs business processing

    }

}
