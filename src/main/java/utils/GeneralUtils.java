package utils;

public class GeneralUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public static void detectDeadlocks() {
        DeadlockDetector deadlockDetector = new DeadlockDetector();
        // Start the deadlock detection in a separate thread
        Thread detectorThread = new Thread(() -> {
            while (true) {
                deadlockDetector.detectDeadlock();
                GeneralUtils.sleep(5_000);
            }
        });

        detectorThread.setDaemon(true);
        detectorThread.start();
    }
}
