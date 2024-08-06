package threadPool.demo1;

import lombok.Getter;

public class Counter {
    @Getter
    private int data;

    private final Object object = new Object();

    public void incrementData() {
        //Some code here
//        synchronized (this) { // Lock
        synchronized (object) { // Lock
            this.data++;
        } // Unlock
        //Some code here
    }

}
