package stopThread.demo1;

public class StoppableRunnable implements Runnable {
    private boolean stopRequested = false;

    public synchronized void requestStopped() {
        this.stopRequested = true;
    }

    public synchronized boolean isStopRequested() {
        return this.stopRequested;
    }

    private void sleep(long millis){

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (!isStopRequested()) {
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Running ......");
        }
        System.out.println(Thread.currentThread().getName() +" is Stopped");

    }
}
