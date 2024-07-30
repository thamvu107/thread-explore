package utils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {
    private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public  void detectDeadlock() {

        long[] deadlockedThreadIds = threadMXBean.findDeadlockedThreads();

        if (deadlockedThreadIds != null) {
            ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(deadlockedThreadIds);
            System.out.println("Detected deadlock threads:");
            for (ThreadInfo threadInfo : threadInfos) {
                System.out.println(threadInfo);
            }
        } else {
            System.out.println("No deadlocks detected.");
        }
    }
}
