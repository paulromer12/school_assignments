// Paul Romer, CSD320, August 17, 2024, Module 2 assignment

// Write a program that calculates the energy needed to heat water from an initial temperature to a final temperature. Your program should prompt the user to enter the amount of water in kilograms and the initial and final temperature of the water.
// The formula to use for this program is:
// 1. Q = waterMass ( finalTemperature – initialTemperature ) x 4184
// 2. waterMass is water weight in kilograms
// 3. finalTemperature and initialTemperature are temperatures in Celsius
// 4. Q is the results in Joules

import java.util.Scanner;

public class EnergyCalculator {
    public static void main(String[] args) {
        // Create scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        double waterMass = 0;
        double initialTemperature = 0;
        double finalTemperature = 0;
        boolean validInput = false;
        
        // Prompt the user for water mass input
        while (!validInput) {
            try {
                System.out.print("The mass of the water in kilograms is: ");
                waterMass = input.nextDouble();
                validInput = true; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Wrong input, please enter a valid number.");
                input.next(); // Clear invalid input
            }
        }

        validInput = false; // Reset for next input

        // Prompt the user for initial temperature input
        while (!validInput) {
            try {
                System.out.print("The initial temperature of the water in Celsius is: ");
                initialTemperature = input.nextDouble();
                validInput = true; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Wrong input, please enter a valid number.");
                input.next(); // Clear invalid input
            }
        }

        validInput = false; // Reset for next input

        // Prompt the user for final temperature input
        while (!validInput) {
            try {
                System.out.print("The final temperature of the water in Celsius is: ");
                finalTemperature = input.nextDouble();
                validInput = true; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Wrong input, please enter a valid number.");
                input.next(); // Clear invalid input
            }
        }
        
        // Calculate the energy required
        double Q = waterMass * (finalTemperature - initialTemperature) * 4184;

        // Display the calculated result
        System.out.println("The energy to raise the temperature of " + waterMass + " kg of water from " + initialTemperature + " degrees celcius to " + finalTemperature + " is " + Q + " joules");
    }
}
