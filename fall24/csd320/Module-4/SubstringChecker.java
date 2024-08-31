// Paul Romer, CSD320, August 31 2024, Module 4.2 assignment
// Write a program that prompts a user to enter two strings and then checks the strings entered and reports if either the first string is a substring of the second string, or if the second string is a substring of the first string.

import java.util.Scanner;

public class SubstringChecker {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // initiate scanner object

        // get user input for first and second string, assigning lower case of input to str1 and str2
        System.out.print("Enter first string: ");
        String str1 = userInput.nextLine().toLowerCase();

        System.out.print("Enter second string: ");
        String str2 = userInput.nextLine().toLowerCase();

        // check if str2 is a substring of str1 and print result
        if (str1.contains(str2)) {
            System.out.println("'" + str2 + "'" + " is a substring of " + "'" + str1 + "'");
        } else {
            System.out.println("'" + str2 + "'" + " is NOT a substring of " + "'" + str1 + "'");
        }

        // check if str1 is a substring of str2 and print result
        if (str2.contains(str1)) {
            System.out.println("'" + str1 + "'" + " is a substring of " + "'" + str2 + "'");
        } else {
            System.out.println("'" + str1 + "'" + " is NOT a substring of " + "'" + str2 + "'");
        }
    }
}
