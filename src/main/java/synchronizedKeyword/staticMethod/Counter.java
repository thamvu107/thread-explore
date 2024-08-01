package synchronizedKeyword.staticMethod;

import lombok.Getter;

public class Counter {

    @Getter
    public static int count;


    public static synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " - Incrementing count.");
        count++;
        System.out.println(Thread.currentThread().getName() + " - Count after increment: " + count + "\n");
    }

    public static synchronized void decrement() {
        System.out.println(Thread.currentThread().getName() + " - Decrementing count.");
        count--;
        System.out.println(Thread.currentThread().getName() + " - Count after decrement: " + count + "\n");
    }

}
