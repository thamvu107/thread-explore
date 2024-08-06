package threadPool.demo1;

public class MyRunnable implements Runnable {
    private final int numIterations;
    private Counter dataHolder;

    public MyRunnable(final int numIterations, final Counter dataHolder) {
        this.numIterations = numIterations;
        this.dataHolder = dataHolder;
    }

    @Override
    public void run() {
        for (int i = 0; i < numIterations; i++) {
            dataHolder.incrementData();
            System.out.println(Thread.currentThread().getName() + ": " + dataHolder.getData());
        }

    }
}
