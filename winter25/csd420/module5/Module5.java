// Paul Romer, Module 5 assignment

// Write a test program that reads words from a text file and displays all non-duplicate words in ascending order and then in descending order.
// The file is to be referenced in the program, not needing to be used as a command line reference.
// The word file is to be titled words.txt and included in your submission.
// Write test code that ensures the code functions correctly.

import java.util.*;
import java.io.*;

public class Module5 {

    public static void main(String[] args) {
        
        // File with words (words.txt)
        String file = "csd420/module5/words.txt";

        // Using the readWordsFromFile() method to read the words from a file called words.txt into a SortedSet called ascendingWords
        TreeSet<String> ascendingWords = readWordsFromFile(file);
        
        // Display words in ascending order
        System.out.println("Words in ascending order:");
        for (String word : ascendingWords) {
            System.out.println(word);
        }
        
        // For descending order use the descendingSet() method on the ascendingWords tree set (already has duplicates removed and is sorted in ascending order). This is a new set in descending order
        Set<String> descendingWords = ascendingWords.descendingSet();
        
        System.out.println("\nWords in descending order:");
        for (String word : descendingWords) {
            System.out.println(word);
        }
        
        // Run tests to ensure the code works correctly
        runTests(ascendingWords, descendingWords);
    }
    
    // Reads words from a file using a scanner object and returns a TreeSet (which sorts them in ascending order). Because it is a set, duplicates are automatically removed.
     
    public static TreeSet<String> readWordsFromFile(String filename) {
        TreeSet<String> wordSet = new TreeSet<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            // Read each word (using whitespace as delimiter)
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordSet.add(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }
        return wordSet;
    }
    
    /**
    * Run a simple test on the functionality, manually creating the TreeSet of the expected output. The file "words.txt" contains the words:
    * 
    * apple
    * apple
    * cherry
    * banana
    * cherry
    * banana
    * pineapple
    * strawberry
    * date
    */

    public static void runTests(TreeSet<String> ascendingWords, Set<String> descendingWords) {
        // Expected result in ascending order
        TreeSet<String> expectedAscending = new TreeSet<>();
        expectedAscending.add("apple");
        expectedAscending.add("banana");
        expectedAscending.add("cherry");
        expectedAscending.add("date");
        expectedAscending.add("pineapple");
        expectedAscending.add("strawberry");
        
        // Test the actual ascending result against the expected ascending results 
        
        if (ascendingWords.equals(expectedAscending)) {
            System.out.println("\nTest Passed: Ascending order is as expected.");
        } else {
            System.out.println("\nTest Failed: Expected ascending order " 
                + expectedAscending + " but got " + ascendingWords);
        }
        
        // For the expected descending order, create a set from the reversed expected ascending set
        Set<String> expectedDescending = expectedAscending.descendingSet();
        
        // Check descending words against the expected descending words
        
        if (descendingWords.equals(expectedDescending)) {
            System.out.println("Test Passed: Descending order is as expected.");
        } else {
            System.out.println("Test Failed: Expected descending order " 
                + expectedDescending + " but got " + descendingWords);
        }
    }
}