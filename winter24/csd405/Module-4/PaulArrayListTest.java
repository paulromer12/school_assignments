// Paul Romer, CSD405, Module 4 Programming Assignment

// PaulArrayListTest class with max method that takes in an integer list, and returns 0 if the list is empty. Given an array of integers, the max method loops through the array and keeps track of the largest value, returning it at the end of the loop. The main method uses a scanner object to get user input of integers adding them to the arraylist list, stopping when 0 is entered. Then that arraylist is passed to the max method and the largest value is output to the terminal. 

import java.util.ArrayList;
import java.util.Scanner;

public class PaulArrayListTest {

    public static Integer max(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        
        int maxValue = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                maxValue = list.get(i);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integer and press enter, type 0 to stop:");
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            int input = scanner.nextInt();
            list.add(input);
            if (input == 0) {
                break;
            }
        }

        Integer maxVal = max(list);

        System.out.println("Largest value: " + maxVal);
    }
}