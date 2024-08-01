package stopThread.interrupt.demo3;

import stopThread.interrupt.demo2.InterruptThreadWithFlag;

public class InterruptThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepWithIsInterrupted());
        thread.start();
        // a little later
        /* may need to adjust the time set for the main thread to execute Thread.sleep on your computer to achieve the same output*/
        Thread.sleep(300);
        thread.interrupt();

        /*
        * Output:
Start moving...
1 batches have been moved
2 batches have been moved
sleep interrupted
4 batches have been moved
5 batches have been moved
End of moving
* */

    }
}
