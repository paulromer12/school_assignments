// Learning how to create a Scanner object and use it to get user input

import java.util.Scanner;

public class CalculateRadiusWithInput {
    public static void main (String[] args) {
        // Create scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a number for the radius: ");
        double radius = input.nextDouble();

        // Compute area
        double area = radius * radius * 3.14159;

        // Display result
        System.out.println("The area for the circle of radius " + radius + " is " + area);

    }
}
