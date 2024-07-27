public class ThreadStates {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("[1] State: " +  Thread.currentThread().getState());
        });

        System.out.println("[2] State: " + thread.getState());

        thread.start();

        System.out.println("[3] State: " + thread.getState());

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("[4] State: " + thread.getState());
    }

}
