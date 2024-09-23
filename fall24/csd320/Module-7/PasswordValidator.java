// Paul Romer, CSD320, MODULE 7 Assignment, September 22 2024

// Some Websites impose certain rules for passwords. Write a method that checks whether a user's input String is a valid password. Suppose the password rules are as follows:
// 1. A password must have at least eight characters.
// 2. A password must contain both letters and digits.
// 3. A password must contain at least one uppercase character.
// 4. A password must contain at least one lowercase character.
import java.util.Scanner;

public class PasswordValidator {
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        // Define booleans for password requirements
        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;

        // Convert string to an array, and loop over each character checking against the password requirements
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
                if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                } else if (Character.isLowerCase(c)) {
                    hasLowercase = true;
                }
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            // If all conditions are met, we can stop early
            if (hasLetter && hasDigit && hasUppercase && hasLowercase) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
        // Instantiate the scanner object
        Scanner scanner = new Scanner(System.in);

        // Get the password from the user, and assign it to the password variable 
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Using the isValidPassword method, check the input password and print the proper response
        if (isValidPassword(password)) {
            System.out.println("Your password is valid.");
        } else {
            System.out.println("Your password is not valid. It must be at least 8 characters long, contain both letters and digits, and have at least one uppercase and lowercase character.");
        }

        scanner.close();
    }
}
