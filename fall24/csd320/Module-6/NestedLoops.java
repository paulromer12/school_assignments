// Paul Romer, csd320, September 9 2024, Module 6.2 assignment
//
// Assignment:
// Write a program that uses nested for loops to output the following with the shown display format:
                    //                1               @
                    //              1 2 1             @
                    //            1 2 4 2 1           @
                    //          1 2 4 8 4 2 1         @
                    //       1 2 4 8 16 8 4 2 1       @
                    //    1 2 4 8 16 32 16 8 4 2 1    @
                    // 1 2 4 8 16 32 64 32 16 8 4 2 1 @

public class NestedLoops {
    public static void main(String[] args) {
        int n = 7;  // Number of rows
        int totalWidth = 32;  // Adjust based on how wide you want the terminal output to be, important in determining where the @ is placed

        for (int i = 1; i <= n; i++) {
            // Step 1: Print leading spaces for alignment
            int currentWidth = 0;  // Track total width for the current row
            for (int j = 1; j <= (n - i) * 2; j++) {
                System.out.print(" ");
                currentWidth++;
            }

            // Step 2: Print the increasing numbers (powers of 2)
            int value = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(value + " ");
                currentWidth += (value + " ").length();  // Add the length of the number and a space
                value *= 2;
            }

            // Step 3: Print the decreasing numbers (powers of 2)
            value /= 2;  // Adjust value to print the decreasing sequence
            for (int j = i - 1; j >= 1; j--) {
                value /= 2;
                System.out.print(value + " ");
                currentWidth += (value + " ").length();  // Add the length of the number and a space
            }

            // Step 4: Calculate and print the remaining spaces and place the "@" symbol
            int remainingSpaces = totalWidth - currentWidth;  // Spaces needed to align "@" to the far right
            System.out.print(" ".repeat(remainingSpaces) + "@");

            // Move to the next line after each row
            System.out.println();
        }
    }
}