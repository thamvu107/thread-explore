package stopThread.interrupt.demo1;

import stopThread.interrupt.demo2.InterruptThreadWithFlag;

public class InterruptThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        //  there is no effect of interrupting thread without flag
        Thread thread = new Thread(new InterruptThreadWithoutFlag());
        thread.start();
        // a little later
        Thread.sleep(2);
        thread.interrupt();
    }
}
