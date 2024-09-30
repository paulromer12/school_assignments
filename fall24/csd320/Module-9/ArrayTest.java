// Write a program that reads and fills an array with 20 integers. Then, using the array elements, calculate the data to find and display:
// The highest value entered.
// The lowest value entered.
// The average of the numbers entered.
// The sum of the numbers entered.
// Display this information in a readable display making the data easy to understand.

public class ArrayTest {
    public static void main (String[] args) {
        
        // Initialize an array of 20 integers
        int[] numbers = new int[20];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 101); // Generate a random number
        }
        
        System.out.print("Stringification of the numbers int array: ");
        System.out.println(numbers);
        System.out.print("Array: ");
        printArray(numbers);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}