package concurent;

import java.util.ArrayList;

public class NonThreadSafeConcurrentJava implements Runnable {

    public static void main(String[] args) {

        System.out.println("This is currently running on the main thread, " + Thread.currentThread().getName());

        new Thread(new Counter()).start();

        int numberOfThreads = 2;
        ArrayList threadList = new ArrayList();
        for (int i = 0; i < numberOfThreads; i++) {
            threadList.add(new Thread(new NonThreadSafeConcurrentJava()));
            ((Thread) threadList.get(i)).start();

        }
    }

    @Override
    public void run() {
        System.out.println("This is currently running on the new thread, " + Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Tic " + i + " from  " + Thread.currentThread().getName());
            } else {
                System.out.println("Toe " + i + " from  " + Thread.currentThread().getName());
            }
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
