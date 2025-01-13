// Paul Romer, CSD 420, Module 1 programming assignment

// Write a program that stores:
// An array of five random integers
// A Date objective instance using the current date
// An array of five random double values
// Write the data in a file titled <yourname> datafile.dat.
// Write a second program that will read the file and display the data.
// Test the code to ensure the code functions correctly.
import java.io.*;
import java.util.Date;
import java.util.Random;

public class ReadWrite {

    public static void main(String[] args) throws IOException {
        // File name
        String filename = "paul_romer_datafile.dat";

        // Write to file
        write(filename);

        // Read from file and display
        read(filename);
    }

    public static void write(String filename) throws IOException {
        // Generate random data
        Random random = new Random();
        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];

        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = random.nextInt(100); // Random integers [0, 99]
            randomDoubles[i] = random.nextDouble() * 100; // Random doubles [0.0, 100.0)
        }

        // Get current date
        Date currentDate = new Date();

        // Write data to file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write integers
            for (int i : randomIntegers) {
                writer.write(i + " ");
            }
            writer.newLine();

            // Write date using Date's toString
            writer.write(currentDate.toString());
            writer.newLine();

            // Write doubles
            for (double d : randomDoubles) {
                writer.write(String.format("%.2f ", d));
            }
            writer.newLine();
        }

        System.out.println("Data written to file: " + filename + "\n");
    }

    public static void read(String filename) throws IOException {
        // Read data from file using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("Reading data from file: " + filename);
            System.out.println("-----------------------------------------------");

            // Read integers
            String intLine = reader.readLine();
            System.out.println("Random Integers: " + intLine);

            // Read date
            String dateLine = reader.readLine();
            System.out.println("Date: " + dateLine);

            // Read doubles
            String doubleLine = reader.readLine();
            System.out.println("Random Doubles: " + doubleLine);
        }
        catch (IOException e) {
            System.err.println("Error: An I/O error occurred while reading the file: " + e.getMessage());
        }
    }
}