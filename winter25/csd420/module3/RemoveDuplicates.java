// Paul Romer, CSD420, Module 3 programming assignment 

// Write a test program that contains a static method that returns a new ArrayList.
// The new ArrayList returned will contain all original values with no duplicates from the original ArrayList.
// Fill the Original ArrrayList with 50 random values from 1 to 20.
// public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
// Write test code that ensures the code functions correctly.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicates {

    public static void main(String[] args) {
        // Create and fill the original list with 50 random integers from 1 to 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        // Remove duplicates with the removeDuplicates method
        ArrayList<Integer> noDuplicatesList = removeDuplicates(originalList);

        // Print out the results
        System.out.println("Original List (50 random values):");
        System.out.println(originalList);

        System.out.println("\nList With Duplicates Removed:");
        System.out.println(noDuplicatesList);
    }

    // Method that returns a new ArrayList with no duplicates from the input list
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        HashSet<E> seen = new HashSet<>();

        for (E element : list) {
            if (!seen.contains(element)) {
                seen.add(element);
                newList.add(element);
            }
        }
        return newList;
    }
}