// Paul Romer, CSD420, Module 2 programming assignment 

// Create a program using a recursive method that returns the sum of the following type inputs.
// m(i) = 1/2 + 2/3 + 3/4 + 4/5 + 5/6 … i/(i + 1)
// ‘m’ is to be replaced with the method name you use.
// Use three different input finishing values, testing your code to ensure it functions correctly.
// Examples: m(4), m(9), m(14).

public class RecursiveSum {
    public static void main(String[] args) {
        // Test with three different values
        System.out.printf("Sum for n=4: %.4f%n", calculateSum(4));
        System.out.printf("Sum for n=9: %.4f%n", calculateSum(9));
        System.out.printf("Sum for n=14: %.4f%n", calculateSum(14));
    }
    
    public static double calculateSum(int i) {
        // Base case
        if (i == 1) {
            return 1.0/2.0;
        }
        // Recursive case
        return (double)i/(i + 1) + calculateSum(i - 1);
    }
}