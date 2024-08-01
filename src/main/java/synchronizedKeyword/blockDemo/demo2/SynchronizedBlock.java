package synchronizedKeyword.blockDemo.demo2;

import lombok.Getter;
import synchronizedKeyword.blockDemo.demo1.SynchronizedBlockDemo;

public class SynchronizedBlock implements Runnable{
    @Getter
    public static int count;

    public static void perform(){
        synchronized (SynchronizedBlockDemo.class) {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    }

    @Override
    public void run() {
        perform();
    }
}
