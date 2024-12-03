// Paul Romer, Module 5 programming assignment, CSD405

// Program 2: Write a program to create a new file titled data.file, if the file does not exist. Then write to the new file, adding 10 randomly generated numbers, or append 10 randomly generated numbers to a previous file. Each integer is to be separated by a space. Close the file, then reopen the file and read the data from the file and display it.

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ProgramTwo {
    public static void main(String[] args) {
        String fileName = "data.file";
        Random rand = new Random();

        // Check if file exists, create it if not, and append 10 random numbers
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true))) {
            System.out.println("Adding 10 random numbers to the file: " + fileName);

            for (int i = 0; i < 10; i++) {
                writer.print(rand.nextInt(100) + " "); 
            }
            writer.println(); 
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }

        // Read the data from the file and display it
        try (Scanner scanner = new Scanner(new File(fileName))) {
            System.out.println("Contents of the file:");
            while (scanner.hasNext()) {
                System.out.print(scanner.next() + " ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}