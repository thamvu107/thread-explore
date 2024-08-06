package threadPool.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    private static final int NUM_THREADS = 10;
    private static final int NUM_ITERATIONS = 10_000;

    public static void main(String[] args) {
        final Counter counter = new Counter();
        MyRunnable myRunnable = new MyRunnable(NUM_ITERATIONS, counter);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        try {
            for (int i = 0; i < NUM_THREADS; i++) {
                executor.submit(myRunnable);
            }
        } finally {
            shutdownAndAwaitTermination(executor);
        }

        System.out.println("Expected: " + (NUM_THREADS * NUM_ITERATIONS) + " Actual: " + counter.getData());
    }

    private static void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}

