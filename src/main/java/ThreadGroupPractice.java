import static java.lang.Thread.MAX_PRIORITY;

public class ThreadGroupPractice {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("threadGroup1");
        threadGroup1.setMaxPriority(MAX_PRIORITY);

        ThreadGroup parentThreadGroup = threadGroup1.getParent();
    }
}
