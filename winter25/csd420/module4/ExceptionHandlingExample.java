public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        double result = numerator / denominator;
        System.out.println("Result: " + result);
        try {
            result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero occurred. Exception: " + e.getMessage());
        }
    }
}