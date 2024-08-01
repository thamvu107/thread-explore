package threadSafe.demo1;

public class NoneThreadSafe {
    private static int count;

    public static void main(String[] args) throws InterruptedException {
        Runnable counter = () -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        };

        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Expected output: Counter: 20000
        System.out.println("Counter: " + count);

    }
}
