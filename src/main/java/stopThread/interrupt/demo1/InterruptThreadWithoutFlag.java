package stopThread.interrupt.demo1;

public class InterruptThreadWithoutFlag implements Runnable{

    //  there is no effect of interrupting thread without flag
    @Override
    public void run() {
        System.out.println("Start moving...");
        for (int i = 1; i <= 5; i++) {
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
