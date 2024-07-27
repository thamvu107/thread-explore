public class ThreadCreation {
    public static void main(String[] args) throws InterruptedException {

//        Thread thread = Thread.currentThread();
//        System.out.println("Current thread name is: " + Thread.currentThread().getName());

        System.out.println("[1] Current thread name is: " + Thread.currentThread().getName());
        // 1. Extend the Thread class
        // 2. Use Runnable interface

        // 1. Extend the Thread class
        MyThreadExtendThread myThread = new MyThreadExtendThread();
        myThread.start(); /// start and run new thread
//        myThread.run();// run thread( main thread) without creating new thread  =>
        myThread.join();
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
