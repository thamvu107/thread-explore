package priority;

public class ThreadGroupOrder {
    public static void main(String[] args) {
        ThreadGroup myThreadGroup = new ThreadGroup("myThreadGroup");
        myThreadGroup.setMaxPriority(6);

        Thread myThread = new Thread(myThreadGroup, "myThread");
        myThread.setPriority(8);

        System.out.println("Thread group priority: " + myThreadGroup.getMaxPriority());
        System.out.println("Thread priority: " + myThread.getPriority());
    }
}
