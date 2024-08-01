package synchronizedKeyword.staticAndNoneStatic;


public class StaticAndNoneStatic {
    public static void main(String[] args) {
        // Note example synchronized static and none static methods
        Thread t1 = new Thread(new MultiMethod.StaticIncreaseThread());
        Thread t2 = new Thread(new MultiMethod.NonStaticIncreaseThread());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final count: " + MultiMethod.getCount()); // Not being 20000
    }
}
