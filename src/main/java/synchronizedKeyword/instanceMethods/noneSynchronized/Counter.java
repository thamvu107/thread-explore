package synchronizedKeyword.instanceMethods.noneSynchronized;

public class Counter {
    private int count;

    public  void increment() {
        System.out.println(Thread.currentThread().getName() + " - Incrementing count.");
        count++;
        System.out.println(Thread.currentThread().getName() + " - Count after increment: " + count + "\n");
    }

    public  void decrement() {
        System.out.println(Thread.currentThread().getName() + " - Decrementing count.");
        count--;
        System.out.println(Thread.currentThread().getName() + " - Count after decrement: " + count + "\n");
    }

    public int getCount() {
        return count;
    }
}
