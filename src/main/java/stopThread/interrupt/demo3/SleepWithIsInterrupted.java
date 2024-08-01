package stopThread.interrupt.demo3;

public class SleepWithIsInterrupted implements Runnable{

    @Override
    public void run() {
        System.out.println("Start moving...");
        for (int i = 1; i <= 5; i++) {
            if(Thread.currentThread().isInterrupted()) {
                //Do some finishing work.
                break;
            }
            //Simulation of time required to move
            try {
                Thread.sleep(1);
                System.out.println(i + " batches have been moved");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("End of moving");
    }

    /*
     * The reason is that once sleep() responds to the interrupt,
     *  it will reset the flag in the isInterrupted() method, so in the loop condition check in the above code,
     *  the result of Thread.currentThread().isInterrupted() is always false,
     * resulting in the program not being able to exit.*/

    /*
    *  so it is not recommended to directly try-catch handle this interrupt exception here,
    *  but directly throw the exception upwards for processing by a higher level,
    *  which is convenient for functional decomposition and team collaboration.
    * Read more: https://blog.stackademic.com/mastering-java-multithreading-7-how-to-properly-stop-a-thread-3655d5fe7bfb
    * */

}
