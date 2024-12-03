// Paul Romer, Module 5 programming assignment, CSD405

// Program 1: Write a program that uses an ArrayList filled with a minimum of 10 Strings. Use a ‘for-each’ loop to print the ArrayList collection. Then ask a user which element they would like to see again. Then, attempt printing the element in a try/catch format which will result in the element being display. If the element value received is invalid, display a message that an Exception has been thrown displaying “Out of Bounds”. In this program, include the use of Autoboxing/Auto-Unboxing, working with a user String input.

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramOne {

    public static void main(String[] args) {
        // initialize scanner object
        Scanner scanner = new Scanner(System.in);
        
        // initialize array and assign 10 values
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("String " + i);
        }

        // print each index in list 
        System.out.println("ArrayList: ");
        for (String str : list) {
            System.out.println(str);
        }

        // get index from user and print the selected index
        System.out.print("\nWhich element would you like to see again? Enter its index: ");
        int index = scanner.nextInt();
        try {
            System.out.println("You selected: " + list.get(index));
        } catch (Exception e) {
            System.out.println("Out of Bounds");
        }
        scanner.close();
    }
}