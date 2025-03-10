// Paul Romer, Module 6 Assignment, CSD420

// Write a program with the two following generic methods using a bubble sort. The first method sorts the elements using the Comparable interface, and the second uses the Comparator interface.
// public static <E extends Comparable<E>>
//  void bubbleSort(E[] list)
// public static <E> void bubbleSort(E[] list,
//  Comparator<? super E> comparator)
// Attached above is a solution zip file for your review. Ensure you actually write your own code, only using the attached solution as an example, and document your code.
// Write test code that ensures your code functions correctly.

import java.util.Comparator;

public class Module6 {

    // Overloaded bubble sort with natural ordering
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
	  bubbleSort(list, (e1, e2) -> ((Comparable<E>)e1).compareTo(e2));
	}

    // Overloaded bubble sort with custom ordering through a comparator. 
	public static <E> void bubbleSort(E[] list,
	    Comparator<? super E> comparator) {
		boolean needNextPass = true;

        /*
         *  Outer loop passes
         * The loop variable k represents the pass number. Each pass “bubbles” the largest unsorted element to its correct position at the end of the array.
         */

		for (int k = 1; k < list.length && needNextPass; k++) {
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (comparator.compare(list[i], list[i + 1]) > 0) {
					/*
                     *  Inner loop comparisons and swaps
                     *  This loop iterates through the unsorted portion of the array (up to list.length - k) and compares adjacent elements.
                     */
					E temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;

					needNextPass = true; 
				}
			}
		}
	}

    // Main method testing the sorts
  public static void main(String[] args) {

    // An array of Integer is created.
    Integer[] list = {1, 9, 3, 7, 6, 2, -2, 3, 14, 12, 5, 4, 10, -1, 11, 13, 0};

    bubbleSort(list);

    /*
    *  The method bubbleSort(list) is called without a comparator because Integer implements Comparable<Integer>. This uses the natural ordering of numbers.
    *  For loop prints each integer from the sorted array.
    */
     
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();


    // An array of String is created.
    String[] list1 = {"abc", "ABC", "abm", "Anf", "Banana", "Bad", "nice", "Cat", "Hotel", "Dog", "Gold", "Fox", "Egg"};

    // The bubbleSort method is called with a comparator defined as (s1, s2) -> s1.compareToIgnoreCase(s2).
    bubbleSort(list1, (s1, s2) -> s1.compareToIgnoreCase(s2));

    // The sorted string array is printed, showing the effect of the case-insensitive sort.
    for (int i = 0; i < list1.length; i++) {
      System.out.print(list1[i] + " ");
    }
  }
}