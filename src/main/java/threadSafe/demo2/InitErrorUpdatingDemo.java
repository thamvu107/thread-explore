package threadSafe.demo2;

import java.util.HashMap;
import java.util.Map;

public class InitErrorUpdatingDemo {
    private Map<Long, String> students;

    public InitErrorUpdatingDemo() throws InterruptedException {
        Thread initThread = new Thread(() -> {
            students = new HashMap<>();
            students.put(1L, "Tom");
            students.put(2L, "Bob");
            students.put(3L, "Victor");
        });

        initThread.start();

        // Wait for the thread to finish
        initThread.join();
    }

    public Map<Long, String> getStudents() {
        return students;
    }

    public static void main(String[] args) throws InterruptedException {
        InitErrorUpdatingDemo initError = new InitErrorUpdatingDemo();
        System.out.println(initError.getStudents().get(1L));
    }
}
