package threadGroup;

public class ThreadGroupDemo {
    public static void main(String[] args) {

        Thread subThread = new Thread(() -> {
            System.out.println("The name of the thread group where subThread is located is：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("The name of the current thread (subThread) is：" +
                    Thread.currentThread().getName());
        });

        subThread.start();
        System.out.println("The thread group name of the thread in which the main() method is executed is： "
                + Thread.currentThread().getThreadGroup().getName());
        System.out.println("The name of the current thread is："
                + Thread.currentThread().getName());


        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup systemThreadGroup = mainThreadGroup.getParent();

        System.out.println("The name of the parent thread group of the thread group where the current thread is located = " + systemThreadGroup.getName());
        System.out.println("The name of the thread group where the current thread is located is = " + mainThreadGroup.getName());
    }
}
