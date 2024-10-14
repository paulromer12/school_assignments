// Paul Romer, CSD320, Module 11 assignment, October 7 2024

// Write methods using the following headers that returns the location of the largest element in the array passed to the method returning a one-dimensional array that contains two location elements.
// public static int [] locateLargest (double [][] arrayParam)
// public static int [] locateLargest (int [][] arrayParam)
// Then, write methods using the following headers that returns the location of the smallest element in the array passed to the method returning a one-dimensional array that contains two location elements.
// public static int [] locateSmallest (double [][] arrayParam)
// public static int [] locateSmallest (int [][] arrayParam)

import java.util.Arrays;

public class ElementLocation {
    public static void main(String[] args) {
        double[][] doubleArray = {
                {6.5, 7.8, 6.7, 8.8},
                {9.1, 2.3, 5.6, 7.7}
        };

        int[][] intArray = {
                {2, 3, 5, 7, 1},
                {2, 4, 8, 16, 32, 64}
        };

        System.out.println("");
        System.out.println("===========================");
        System.out.println("Element Location and Value");
        System.out.println("===========================");
        System.out.println("");

        int[] largestDouble = locateLargest(doubleArray);
        System.out.println("Location of largest element in doubleArray: " + Arrays.toString(largestDouble));
        System.out.println("The largest element in doubleArray is: " + doubleArray[largestDouble[0]][largestDouble[1]] + '\n');

        int[] smallestDouble = locateSmallest(doubleArray);
        System.out.println("Location of smallest element in doubleArray: " + Arrays.toString(smallestDouble));
        System.out.println("The largest element in doubleArray is: " + doubleArray[smallestDouble[0]][smallestDouble[1]] + '\n');

        int[] largestInteger = locateLargest(intArray);
        System.out.println("Location of largest element in intArray: " + Arrays.toString(largestInteger));
        System.out.println("The largest element in intArray is: " + intArray[largestInteger[0]][largestInteger[1]] + '\n');

        int[] smallestInteger = locateSmallest(intArray);
        System.out.println("Location of smallest element in intArray: " + Arrays.toString(smallestInteger));
        System.out.println("The largest element in intArray is: " + intArray[smallestInteger[0]][smallestInteger[1]] + '\n');
    }

    public static int[] locateLargest(double[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return new int[]{-1, -1};
        }

        double max = array[0][0];
        int row = 0, col = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[]{row, col};
    }

    public static int[] locateSmallest(double[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return new int[]{-1, -1};
        }

        double min = array[0][0];
        int row = 0, col = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[]{row, col};
    }

    public static int[] locateLargest(int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return new int[]{-1, -1};
        }

        int max = array[0][0];
        int row = 0, col = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[]{row, col};
    }

    public static int[] locateSmallest(int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return new int[]{-1, -1};
        }

        int min = array[0][0];
        int row = 0, col = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[]{row, col};
    }
}