package threadSafe.noneThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImproveNoneThreadSafeExample {
    public static void main(String[] args) {
        // Create a non-thread-safe list to store integers
        List<Integer> intList = Collections.synchronizedList(new ArrayList<>());

        // Create and start multiple threads to add integers to the list
        Thread t1 = new Thread(() -> addIntegers(intList, 0, 5, "Thread1"));
        Thread t2 = new Thread(() -> addIntegers(intList, 5, 11, "Thread2"));

        t1.start();
        t2.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the contents of the list as a list
        System.out.println("Contents of intList: " + intList);

        // Sort the list and print the sorted contents of the list
        Collections.sort(intList);
        System.out.println("Sorted contents of intList: " + intList);

        // Calculate the sum of the integers in the list
        int sum = intList.stream().mapToInt(Integer::intValue).sum();

        // Print the result
        System.out.println("Sum of integers in the list: " + sum);
    }

    private static void addIntegers(List<Integer> list, int start, int end, String threadName) {
        synchronized (list) {
        for (int i = start; i < end; i++) {
            list.add(i);
            System.out.println(threadName + " added: " + i);

            // Simulate some processing time
            try {
                Thread.sleep(1000); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
    }
}
