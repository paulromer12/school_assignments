public class Module1 {
    public static void main(String[] args) {
        // prints math statements
        System.out.println ("The result with doubles: " + 4 * (1.0 - 1.0 / 3.0 + 1.0 / 5.0 - 1.0 / 7.0 + 1.0 / 9.0 - 1.0 / 11.0 + 1.0 / 13.0));
        System.out.println ("The result with integers: " + 4 * ( 1 - 1 / 3 + 1 / 5 - 1 / 7 + 1 / 9 - 1 / 11 + 1 / 13 ));
    }
 }

/* Double vs Integer Literal Division 
 * The first statement prints 3.2837384837384844 to the terminal.
 * The second statement prints 4 to the terminal. 
 * 
 * The reason that these seemingly same expressions return different values is the way Java handles the types of the
 * numbers invovled.
 * 
 * - The first expression uses numbers that are the double data types. Java handles the division of doubles with more 
 *   precision because it performs floating-point division, perserving the decimal places. When this is evaluated following PMDAS,
 *   what's in the parenthasis is evaluated first. Within the parenthasis, division is done first. 1.0 / 3.0 = .333...,
 *   1.0 / 5.0 = .200..., etc. Then the addition and subtraction is evaluated, and then the result is multiplied by 4. 
 * 
 * - The second expression uses numbers that are integer data types. Java handles the division of integers with 
 *   less precision because it discards the decimal part. When evaluated, the integers 1 / 3 = 0. In traditional math and floating-point
 *   math, it would result in .333... but because we are using integers, what is to the right of the decimal is lost, changing 
 *   the precision of the calculation and the final answer to 4, instead of 3.2837384837384844 when the division is done with doubles. 
 */
