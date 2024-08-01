package threadLivenessProblems.starvation;

public class StarvationDemo {
    public static void main(String[] args) {
        System.out.println("Main thread execution starts");

        // Thread priorities are set in a way that thread5
        // gets least priority.
        Starvation thread1 = new Starvation();
        thread1.setPriority(10);
        Starvation thread2 = new Starvation();
        thread2.setPriority(9);
        Starvation thread3 = new Starvation();
        thread3.setPriority(8);
        Starvation thread4 = new Starvation();
        thread4.setPriority(7);
        Starvation thread5 = new Starvation();
        thread5.setPriority(6);

        thread1.run();
        thread2.run();
        thread3.run();
        thread4.run();

        // Here thread5 have to wait because of the
        // other thread. But after waiting for some
        // interval, thread5 will get the chance of
        // execution. It is known as Starvation
        thread5.run();

        System.out.println("Main thread execution completes");
    }
}
