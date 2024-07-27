public class MyThreadExtendThread extends Thread {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        setName("MyThreadExtendThread");
        System.out.println("[2] Start thread name is: " + thread.getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

    }
}
