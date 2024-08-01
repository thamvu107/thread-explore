package stopThread.interrupt.demo2;

public class InterruptThreadWithFlag implements Runnable {
    @Override
    public void run() {
        System.out.println("Start moving...");
        for (int i = 1; i <= 5; i++) {
            if (Thread.currentThread().isInterrupted()) {
                //Do some finishing work.
                break;
            }
            //Simulation of time required to move
            int j = 50000;
            while (j > 0) {
                j--;
            }
            System.out.println(i + " batches have been moved");
        }
        System.out.println("End of moving");
    }
}
