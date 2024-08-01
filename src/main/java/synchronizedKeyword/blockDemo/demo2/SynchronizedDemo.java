package synchronizedKeyword.blockDemo.demo2;

public class SynchronizedDemo {
    public static void main(String[] args) {
        SynchronizedBlock synchronizedBlock= new SynchronizedBlock();
        Thread thread1 = new Thread(synchronizedBlock);
        Thread thread2 = new Thread(synchronizedBlock);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final count:  " +synchronizedBlock.getCount());
    }
}
