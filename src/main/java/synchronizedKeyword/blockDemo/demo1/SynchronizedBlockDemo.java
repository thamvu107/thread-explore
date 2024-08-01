package synchronizedKeyword.blockDemo.demo1;

public class SynchronizedBlockDemo {
    static int count;

    public static void main(String[] args) throws InterruptedException {

//        SynchronizedBlockDemo synchronizedBlockDemo = new SynchronizedBlockDemo();

        // If the method was static, we would pass the class name in place of the object reference
        Runnable runnable = () -> {
//            synchronized (synchronizedBlockDemo) {
            synchronized (SynchronizedBlockDemo.class) {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final count: " + count);
    }
}
