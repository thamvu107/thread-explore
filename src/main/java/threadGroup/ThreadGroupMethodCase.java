package threadGroup;

import utils.GeneralUtils;

public class ThreadGroupMethodCase {
    public static void main(String[] args) {

        ThreadGroup subgroup1 = new ThreadGroup("Subgroup1");

        Thread t1 = new Thread(subgroup1, "t1 in Subgroup1");
        Thread t2 = new Thread(subgroup1, "t2 in Subgroup1");
        Thread t3 = new Thread(subgroup1, "t3 in Subgroup1"); // NEW

        t1.start();
        GeneralUtils.sleep(50);
        t2.start();

        int activeThreadCount1 = subgroup1.activeCount(); // exclude NEW & TERMINATED ( t1 is TERMINATED  & t3 is NEW) => only t2 is active
        System.out.println("Active thread in " + subgroup1.getName() + " thread group: " + activeThreadCount1);

        ThreadGroup subgroup2 = new ThreadGroup("subgroup2");
        Thread t4 = new Thread(subgroup2, "t4 in subgroup2");

        int activeThreadCount2 = subgroup2.activeCount();
        System.out.println("Active thread in " + subgroup2.getName() + " thread group: " + activeThreadCount2);


        ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();

        int activeGroupCount = currentThreadGroup.activeGroupCount();
        System.out.println("Active thread groups in " + currentThreadGroup.getName() + " thread group: " + activeGroupCount);

        System.out.println("\nPrints information about currentThreadGroup to the standard output:");
        currentThreadGroup.list();
    }
}
