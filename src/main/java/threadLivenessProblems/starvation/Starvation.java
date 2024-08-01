package threadLivenessProblems.starvation;

public class Starvation extends Thread {
    static int threadcount = 1;
    public void run()
    {
        System.out.println(threadcount + "st Child" +
                " Thread execution starts");
        System.out.println("Child thread execution completes");
        threadcount++;
    }
}
