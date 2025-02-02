// Paul Romer, module 4 assignment

// Write a test program that stores 50,000 integers in LinkedList and test the time to traverse the list using an iterator vs. using the get(index) method.
// Then, test your program storing 500,000 integers.
// After completing this program and having tested both values, in your comments, explain the results and discuss the time taken using both values and their difference with the get(index) approach.
// Write test code that ensures the code functions correctly.

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class LinkedListAssignment {
    public static void main(String[] args) {
        // Test with both 50,000 and 500,000 integers
        testLinkedList(50000);
        testLinkedList(500000);
    }

    public static void testLinkedList(int size) {
        System.out.println("\nTesting with " + size + " integers:");
        
        // Create LinkedList and populate it
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }

        // Test traversal using Iterator
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        long time_taken = (endTime - startTime);
        double seconds = time_taken / 1000.0;
        System.out.println("Time taken with Iterator: " + time_taken + "ms or " + seconds + "s");

        // Test traversal using get(index)
        int list_size = list.size();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list_size; i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        time_taken = (endTime - startTime);
        seconds = time_taken / 1000.0;
        System.out.println("Time taken with get(index): " + time_taken + "ms or " + seconds + "s");
    }
}

// Output: 
// The outputs vary run to run, but an example of one of the runs is: 
// -----------
// Testing with 50000 integers:
// Time taken with Iterator: 2ms or 0.002s
// Time taken with get(index): 993ms or 0.993s

// Testing with 500000 integers:
// Time taken with Iterator: 2ms or 0.002s
// Time taken with get(index): 106274ms or 106.274s
// -----------

// Explanation: 
// Using get(index) on a linked list repeatedly is O(n^2) overall because 
// each get operation is O(n). The iterator approach is O(n), because it 
// just steps through each node in one pass.