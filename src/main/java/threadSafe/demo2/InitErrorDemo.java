package threadSafe.demo2;

import java.util.HashMap;
import java.util.Map;

public class InitErrorDemo {
    private Map<Long, String> students;

    public InitErrorDemo() {
        new Thread(() -> {
            students = new HashMap<>();
            students.put(1L, "Tom");
            students.put(2L, "Bob");
            students.put(3L, "Victor");
        }).start();
    }

    public Map<Long, String> getStudents() {
        return students;
    }

    public static void main(String[] args) throws InterruptedException {
        InitErrorDemo initError = new InitErrorDemo();
        System.out.println(initError.getStudents().get(1L));
    }
}
