public class Calculator {
    public static void main(String[] args) {
        // Define the lambda expression
        MathOperation sum = (x, y) -> x + y;
        
        // Use the lambda expression
        int result = sum.operation(5, 3);
        
        // Print the result 8
        System.out.println("Sum: " + result);
    }
}