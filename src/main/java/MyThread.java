public class MyThread extends Thread {

    @Override
    public void run() {
        setName("MyThread");
        System.out.println("[2] Current thread name is: " + Thread.currentThread().getName());
    }
}
