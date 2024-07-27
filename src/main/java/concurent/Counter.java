package concurent;

public class Counter implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Dog " +i + " from Counter " + Thread.currentThread().getName());
            } else {
                System.out.println("Meo " +i + " from Counter " + Thread.currentThread().getName());
            }
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
