package stopThread.interrupt.demo2;

public class InterruptThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // if we use interrupt thread with flag then  the interrupt() method interrupt is valid,
        // this is a standard way of handling it.
        Thread thread = new Thread(new InterruptThreadWithFlag());
        thread.start();
        Thread.sleep(2);
        thread.interrupt();
    }
}
