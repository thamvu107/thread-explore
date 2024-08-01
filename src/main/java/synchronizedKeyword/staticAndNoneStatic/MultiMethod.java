package synchronizedKeyword.staticAndNoneStatic;

import lombok.Getter;

public class MultiMethod{

    @Getter
    public static int count;

    static class StaticIncreaseThread implements Runnable {
        public static synchronized void increase() {
            count++;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                increase();
            }
        }
    }

    static class NonStaticIncreaseThread implements Runnable {
        public synchronized void increaseNonStatic() {
            count++;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                increaseNonStatic();
            }
        }
    }
}
