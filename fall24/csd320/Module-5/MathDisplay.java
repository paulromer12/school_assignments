// Paul Romer, CSD 320, September 1 2024, Module 5.2 Assignment

// Write a program that uses a while loop to display the following math operations both in the smaller to larger order and then the larger to smaller order with the denominator being 3 through 99.  Ensure your application displays the mathematical results.
// 1/3.0 + 1/5.0 + 1/7.0 + ··· + 1/95.0 + 1/97.0 + 1/99.0
// 1/99.0 + 1/97.0 + 1/95.0 + ··· + 1/7.0 + 1/5.0 + 1/3.0

public class MathDisplay {
   public static void main(String[] args) {
       // smaller to larger (only odd numbered denominators)
       double sum1 = 0.0;
       System.out.println("Results (smaller to larger denominator): ");

       int denominator = 3; 
       while (denominator <= 99) {
           if (denominator % 2 != 0) { 
               System.out.println("1/" + denominator + " + " + sum1 + " = " + (sum1 += 1.0 / denominator));
               sum1 += 1 / denominator;
           }
           denominator++;
       }

       double result1 = sum1;
       System.out.println("Final Sum (smaller to larger denominator): " + result1);

       // larger to smaller (only odd numbered denominators)
       double sum2 = 0.0;
       System.out.println("Results (larger to smaller denominator): ");

       int denominator2 = 99; 

       while (denominator2 >= 3) {
           if (denominator2 % 2 != 0) { 
               System.out.println("1/" + denominator2 + " + " + sum2 + " = " + (sum2 += 1.0 / denominator2));
               sum2 += 1 / denominator2;
           }
           denominator2--;
       }

       double result2 = sum2;
       System.out.println("Final Sum (larger to smaller denominator): " + result2);


       // print final results
       System.out.println("\n" + "The sum from the smaller to larger denominator is " + result1 + " and the sum from the larger to smaller denominator is " + result2 + ".");
   }
}