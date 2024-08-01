package threadJoin;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread (new YouSayHello(), "T1");
        Thread t2 = new Thread (new ISayHi(), "T2");

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

        System.out.println("Before join t1.isAlive : " + t1.isAlive());
        System.out.println("Before join t2.isAlive : " + t2.isAlive());

        t1.join();
        t2.join();

        System.out.println("After join t1.isAlive: " + t1.isAlive());
        System.out.println("After join t2.isAlive: " + t2.isAlive());

        System.out.println("\nGoodBye");


    }

}
