// Paul Romer, CSD320, Aug 27, 2024, Module 3.2 Assignment
// Write a program that is similar to the popular game titled “Rock-Paper-Scissors.” The program randomly generates the number of 1, 2, or 3 with 1 being Rock, 2 being Paper, and 3 being Scissors. Then, the program is to prompt the user to enter a value of 1, 2, or 3. Next, the program displays a clear readable message displaying both the computer’s selection, the user’s selection, and the results.

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors { 
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String choices[] = {"Rock", "Paper", "Scissors"};

        int computerSelection = random.nextInt(3) + 1;
        int userSelection = 0;

        System.out.println();
        System.out.println("Let's play Rock-Paper-Scissors!");
        
        System.out.println("Rock is 1");
        System.out.println("Paper is 2");
        System.out.println("Scissors is 3");
        System.out.println();


        while (true) {
            try {
                System.out.print("Enter a number between 1 - 3: ");
                userSelection = input.nextInt();
                if (userSelection < 1 || userSelection > 3) {
                    System.out.println("Invalid input. Please enter a number between 1 - 3.");
                } else {
                    break; // Exit the loop if valid input
                }
            } catch (Exception e) {
                input.next(); // clear invalid input
            }
        }
        
        System.out.println();
        System.out.println("You chose " + choices[userSelection-1] + " and the computer chose " + choices[computerSelection-1] + "!");

        if ((userSelection == 1 && computerSelection == 3) || (userSelection == 2 && computerSelection == 1) || (userSelection == 3 && computerSelection == 2)) {
            System.out.println("--You win!--");
        } else if ((computerSelection == 1 && userSelection == 3) || (computerSelection == 2 && userSelection == 1) || (computerSelection == 3 && userSelection == 2)) {
            System.out.println("The Computer wins...");
        } else {
            System.out.println("It's a tie!");
        }

        System.out.println("Thanks for playing Rock-Paper-Scissors!");
    }
}