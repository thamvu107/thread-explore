package synchronizedKeyword.instanceMethods.noneSynchronized;

public class InstanceMethodDemo {


    public static void main(String[] args) {

        int maxIncrement = 30000;
        int maxDecrement = 20000;

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < maxIncrement; i++) {
                counter.increment();
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < maxDecrement; i++) {
                counter.decrement();
            }
        }, "T2");

        t1.start();
        t2.start();

//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // Print final result.
        System.out.println("Final count: " + counter.getCount());
    }
}
