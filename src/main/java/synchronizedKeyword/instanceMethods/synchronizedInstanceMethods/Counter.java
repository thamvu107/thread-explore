package synchronizedKeyword.instanceMethods.synchronizedInstanceMethods;

public class Counter {
    private int count;

    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " - Incrementing count.");
        count++;
        System.out.println(Thread.currentThread().getName() + " - Count after increment: " + count + "\n");
    }

    public synchronized void decrement() {
        System.out.println(Thread.currentThread().getName() + " - Decrementing count.");
        count--;
        System.out.println(Thread.currentThread().getName() + " - Count after decrement: " + count + "\n");
    }

    public synchronized int getCount() {
        return count;
    }
}
