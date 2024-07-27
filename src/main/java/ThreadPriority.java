import static java.lang.Thread.*;

public class ThreadPriority {
    public static void main(String[] args) throws InterruptedException {
//        Thread thr1= new Thread(new MyThreadImplementRunnable(),"Thread1");
//        Thread thr2= new Thread(new MyThreadImplementRunnable(),"Thread2" );
//        Thread thr3= new Thread(new MyThreadImplementRunnable(),"Thread3");

        Thread thr1= new Thread(new MyThreadImplementRunnable("Thread1"));
        Thread thr2= new Thread(new MyThreadImplementRunnable("Thread2" ));
        Thread thr3= new Thread(new MyThreadImplementRunnable("Thread3"));

        // Set priority for each thread ( However, priority is also based on JVM scheduling algorithm)
        thr1.setPriority(MIN_PRIORITY);
        thr2.setPriority(NORM_PRIORITY);
        thr3.setPriority(MAX_PRIORITY);

        thr1.start();
        thr2.start();
        thr3.start();


        // Wait for threads to finish
        try {
            thr1.join();
            thr2.join();
            thr3.join();
        } catch (InterruptedException e) {
         e.printStackTrace();
        }
        System.out.println("All threads have finished execution");
    }
}
