public class ThreadCreation {
    public static void main(String[] args) throws InterruptedException {

//        Thread thread = Thread.currentThread();
//        System.out.println("Current thread name is: " + Thread.currentThread().getName());

        System.out.println("[1] Current thread name is: " + Thread.currentThread().getName());

        // 1. Extend the Thread class
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
//        myThread.run(); // main thread
//        Thread.sleep(3000);
        System.out.println("[3] Current thread name is: " + myThread.getName());

//        2. Runnable interface function

//        Anonymous new Runnable()
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Current thread name is: " + Thread.currentThread().getName());
//            }
//        };

        // lambda
//        Runnable runnable = () -> System.out.println("Current thread name is: " + Thread.currentThread().getName());
//        Thread threadRunnable = new Thread(runnable);

//        Runnable runnable = () -> System.out.println("Current thread name is: " + Thread.currentThread().getName());
        Thread threadRunnable = new Thread(() -> {
            System.out.println("[4] Current thread name is: " + Thread.currentThread().getName());
        });
        threadRunnable.setName("ThreadRunnable");
        threadRunnable.start();
        threadRunnable.join();
//        Thread.sleep(3000);
        System.out.println("[5] Current thread name is: " + Thread.currentThread().getName());
    }


}
