// Paul Romer, CSD320, August 17, 2024, Module 2 assignment

// Write a program that calculates the energy needed to heat water from an initial temperature to a final temperature. Your program should prompt the user to enter the amount of water in kilograms and the initial and final temperature of the water.
// The formula to use for this program is:
// 1. Q = waterMass ( finalTemperature – initialTemperature ) x 4184
// 2. waterMass is water weight in kilograms
// 3. finalTemperature and initialTemperature are temperatures in Celsius
// 4. Q is the results in Joules

public class EnergyCalculator {
    public static void main(String[] args) {
        // Prompt the user for input
        double waterMass = 1;
        double initialTemperature = 60;
        double finalTemperature = 100;

        // Calculate the energy required
        double Q = waterMass * (finalTemperature - initialTemperature) * 4184;

        // Display the calculated result
        System.out.println("The energy to raise the temperature of " + waterMass + " kg of water from " + initialTemperature + " degrees celcius to " + finalTemperature + " is " + Q + " joules");
    }
}
