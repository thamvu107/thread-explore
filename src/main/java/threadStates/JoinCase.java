package threadStates;

public class JoinCase {
    private synchronized void businessProcessing() {
        try {
            System.out.println("Thread[" + Thread.currentThread().getName() + "] performs business processing");
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        JoinCase blockedCase = new JoinCase();
        Thread A = new Thread(blockedCase::businessProcessing, "A");
        Thread B = new Thread(blockedCase::businessProcessing, "B");
        Thread C = new Thread(blockedCase::businessProcessing, "C");

        System.out.println("\nPlease ask thread A to go to the window to handle the business.");
        A.start();
        A.join();

        System.out.println("\nPlease ask thread B to go to the window to handle the business.");
        B.start();
        B.join();

        System.out.println("\nPlease ask thread C to go to the window to handle the business.");
        C.start();
    }
}
