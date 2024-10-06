// Paul Romer, Module 10 assignment, CSD320, October 3 2024

// Write four overloaded methods that return the average of an array with the following headers:
// public static short average(short [] array)
// public static int average(int [] array)
// public static long average(long [] array)
// public static double average(double [] array)
// Write a test program that invokes each of these methods and then displays the average value returned along with a display of the original array elements. Ensure the display is easy to read and understandable. Lastly, each array sent into the methods must be of different sizes to ensure the method code is correctly written.

public class OverloadedMethods {
    public static void main (String[] args) {

        // Arrays of different sizes and types
        short[] shortsArray = {1, 2};
        int[] intsArray = {10, 20, 30, 40};
        long[] longsArray = {1000L, 2000L, 3000L, 4000L, 5000L};
        double[] doublesArray = {5.0, 15.6, 29.1, 34.8, 43.2, 67.8};

        // Invoke each method and print the results
        System.out.println(" ");
        System.out.println("Array of Shorts: ");
        printArray("Shorts", shortsArray);
        System.out.println("Average of Shorts: " + average(shortsArray));

        System.out.println("\nArray of Ints: ");
        printArray("Ints", intsArray);
        System.out.println("Average of Ints: " + average(intsArray));

        System.out.println("\nArray of Longs: ");
        printArray("Longs", longsArray);
        System.out.println("Average of Longs: " + average(longsArray));

        System.out.println("\nArray of Doubles: ");
        printArray("Doubles", doublesArray);
        System.out.println("Average of Doubles: " + average(doublesArray));
    }

    // Overloaded methods to print the array of various types in a readable format
    public static void printArray(String prefix, short[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print("Element " + (i + 1) + ": " + array[i] + ", ");
            } else {
                System.out.print("Element " + (i + 1) + ": " + array[i]);
            }
        }
        System.out.println();
    }

    public static void printArray(String prefix, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print("Element " + (i + 1) + ": " + array[i] + ", ");
            } else {
                System.out.print("Element " + (i + 1) + ": " + array[i]);
            }
        }
        System.out.println();
    }

    public static void printArray(String prefix, long[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print("Element " + (i + 1) + ": " + array[i] + ", ");
            } else {
                System.out.print("Element " + (i + 1) + ": " + array[i]);
            }
        }
        System.out.println();
    }

    public static void printArray(String prefix, double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print("Element " + (i + 1) + ": " + array[i] + ", ");
            } else {
                System.out.print("Element " + (i + 1) + ": " + array[i]);
            }
        }
        System.out.println();
    }

    // Overloaded methods to calculate the average of an array based on type
    public static short average(short[] array) {
        int sum = 0;
        for (short s : array) {
            sum += s;
        }
        return (short) (sum / array.length);
    }

    public static int average(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return (int) sum / array.length;
    }

    public static long average(long[] array) {
        long sum = 0;
        for (long l : array) {
            sum += l;
        }
        return (long) sum / array.length;
    }

    public static double average(double[] array) {
        double sum = 0;
        for (double d : array) {
            sum += d;
        }
        return (double) sum / array.length;
    }
}