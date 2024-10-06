// Write a program that reads and fills an array with 20 integers. Then, using the array elements, calculate the data to find and display:
// The highest value entered.
// The lowest value entered.
// The average of the numbers entered.
// The sum of the numbers entered.
// Display this information in a readable display making the data easy to understand.
import java.util.Scanner;

public class ArrayTest {
    public static void main (String[] args) {
        // Initialize scanner object
        Scanner scanner = new Scanner(System.in);

        // Initialize an array of 20 integers and get input from user
        int[] numbers = new int[20];

        System.out.println("Enter 20 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        // Calculate the data
        int highest = findHighestValue(numbers);
        int lowest = findLowestValue(numbers);
        double average = calculateAverage(numbers);
        int sum = calculateSum(numbers);

        System.out.println("\nAnalysis:");
        System.out.println("----------------");
        System.out.printf("Highest value: %d%n", highest);
        System.out.printf("Lowest value: %d%n", lowest);
        System.out.printf("Average: %.2f%n", average);
        System.out.printf("Sum: %d%n", sum);

        // Print the numbers array
        System.out.println("\nNumbers entered:");
        printArray(numbers, scanner);

        // Close the scanner
        scanner.close();
    }

    // Method to find and return the highest value from the array
    public static int findHighestValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Method to find and return the lowest value from the array
    public static int findLowestValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Method to calculate and return the average of all elements in the array
    public static double calculateAverage(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return (double) sum / array.length;
    }

    // Method to calculate and return the sum of all elements in the array
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    // Helper method to print the contents of an array
    public static void printArray(int[] array, Scanner scanner) {
        System.out.print(" ");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}