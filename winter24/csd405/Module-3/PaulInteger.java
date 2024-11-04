// Paul Romer, CSD405, Module 3 Assignment, Nov 3 2024

public class PaulInteger {
    private int paul;

    // Constructor
    public PaulInteger(int value) {
        this.paul = value;
    }

    // Getter and Setter
    public int getValue() {
        return paul;
    }

    public void setValue(int value) {
        this.paul = value;
    }

    // Non-static methods
    public boolean isEven() {
        return paul % 2 == 0;
    }

    public boolean isOdd() {
        return paul % 2 != 0;
    }

    public boolean isPrime() {
        if (paul <= 1) return false;
        for (int i = 2; i <= Math.sqrt(paul); i++) {
            if (paul % i == 0) return false;
        }
        return true;
    }

    // Static methods with int parameter
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isEven(PaulInteger num) {
        return num.getValue() % 2 == 0;
    }

    public static boolean isOdd(PaulInteger num) {
        return num.getValue() % 2 != 0;
    }

    public static boolean isPrime(PaulInteger num) {
        return isPrime(num.getValue());
    }

    // equals methods
    public boolean equals(int num) {
        return this.paul == num;
    }

    public boolean equals(PaulInteger num) {
        return this.paul == num.getValue();
    }

    // Test main method
    public static void main(String[] args) {
        // Create three instances (two with same value, one different)
        PaulInteger num1 = new PaulInteger(17);
        PaulInteger num2 = new PaulInteger(17);
        PaulInteger num3 = new PaulInteger(20);

        // Test non-static methods
        System.out.println("\nTesting non-static methods for num1 (17):");
        System.out.println("isEven(): " + num1.isEven());
        System.out.println("isOdd(): " + num1.isOdd());
        System.out.println("isPrime(): " + num1.isPrime());

        // Test static methods with int parameter
        System.out.println("\nTesting static methods with int parameter (20):");
        System.out.println("isEven(20): " + isEven(20));
        System.out.println("isOdd(20): " + isOdd(20));
        System.out.println("isPrime(20): " + isPrime(20));

        // Test static methods with PaulInteger parameter
        System.out.println("\nTesting static methods with PaulInteger parameter (num3 = 20):");
        System.out.println("isEven(num3): " + isEven(num3));
        System.out.println("isOdd(num3): " + isOdd(num3));
        System.out.println("isPrime(num3): " + isPrime(num3));

        // Test equals methods
        System.out.println("\nTesting equals methods:");
        System.out.println("num1.equals(17): " + num1.equals(17));
        System.out.println("num1.equals(num2): " + num1.equals(num2));
        System.out.println("num1.equals(num3): " + num1.equals(num3));

        // Test getter and setter
        System.out.println("\nTesting getter and setter:");
        System.out.println("Original value: " + num3.getValue());
        num3.setValue(25);
        System.out.println("After setValue(25): " + num3.getValue());
    }
}