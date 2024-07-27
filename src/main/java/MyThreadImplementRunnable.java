public class MyThreadImplementRunnable implements Runnable{
    private String name;
    public MyThreadImplementRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Start thread: " + thread.getName());
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Wake up: " + thread.getName() + " priority: " + thread.getPriority() + " value: " + i);
        }

    }
}
