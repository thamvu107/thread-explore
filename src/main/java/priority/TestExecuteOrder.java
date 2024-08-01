package priority;

public class TestExecuteOrder {
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.printf("The currently executing thread is：%s，priority：%d%n",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority());
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.setPriority(1);

        Thread t2 = new Thread(new MyRunnable());
        t2.setPriority(5);

        Thread t3 = new Thread(new MyRunnable());
        t3.setPriority(10);

        t3.start();
        t2.start();
        t1.start();

        // If executed sequentially, this program should output in the order 10, 5, 1. But execution is determined by the operating system’s thread scheduling algorithm
    }
}
