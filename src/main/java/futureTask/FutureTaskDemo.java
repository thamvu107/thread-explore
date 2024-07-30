package futureTask;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int start1 = 1;
        int end1 = 10;

        int start2 = 11;
        int end2 = 14;


        // 1. Create Callable tasks with different ranges
        MyCallable myCallable1 = new MyCallable(start1, end1);
        MyCallable myCallable2 = new MyCallable(start2, end2);

        // 2. Create FutureTasks for each Callable
        FutureTask<Integer> futureTask1 = new FutureTask<>(myCallable1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myCallable2);

        // 3.Create threads for each FutureTask
        Thread t1 = new Thread(futureTask1, "T1");
        Thread t2 = new Thread(futureTask2, "T2");

        // 4.start the threads
        t1.start();
        t2.start();

        // 5.Get calculation results
        Integer sum1 = futureTask1.get();
        Integer sum2 = futureTask2.get();

        System.out.println("Sum of " + t1.getName() + " from "+ myCallable1.getStart() + " to " + myCallable1.getEnd() + ": " + sum1);
        System.out.println("Sum of " + t2.getName() + " from "+ myCallable2.getStart() + " to " + myCallable2.getEnd() + ": " + sum2);
    }

}
