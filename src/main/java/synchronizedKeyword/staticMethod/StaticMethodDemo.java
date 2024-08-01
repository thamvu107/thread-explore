package synchronizedKeyword.staticMethod;

public class StaticMethodDemo {

    public static void main(String[] args) throws InterruptedException {
        int maxIncrement = 300;
        int maxDecrement = 100;

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < maxIncrement; i++) {
                Counter.increment();
            }
        }, "T1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < maxDecrement; i++) {
                Counter.decrement();
            }
        }, "T2");


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final Count: " + Counter.getCount());
    }
}
