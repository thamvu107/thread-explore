package threadInterference;

public class ThreadInterferenceDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();


        Runnable task1 = () -> {
            for (int i = 0; i < 1_000; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " " + counter.getCount());

            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 1_500; i++) {
                counter.decrement();
                System.out.println(Thread.currentThread().getName() + " " + counter.getCount());
            }
        };

        Thread t1 = new Thread(task1, "Increasing T1");
        Thread t2 = new Thread(task1, "Increasing T2");
        Thread t3 = new Thread(task2, "Decreasing T3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Count: " + counter.getCount());
    }
}
