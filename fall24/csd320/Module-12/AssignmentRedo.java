// Paul Romer, October 13 2024, Module 8 Assignment Redo
// Feedback: The following requirement was not met. Write a main method that will test each of these methods two times.

// For this assignment, you may redo one of the programming assignments you previously did and are not satisfied with your score.
// Attach your work to this assignment and you will be given makeup points based on the quality of the update.
// Include which module assignment you are redoing for this assignment.

// Write a program with four methods for calculating the cost of a yearly auto service visit. The methods will be titled yearlyService.
// yearlyService(no parameters) - Will return the standard service charge.
// yearlyService(one parameter) - Will return the standard service charge with an added oil change fee.
// yearlyService(two parameters) - Will return the standard service charge with an added oil change fee and a tire rotation charge.
// yearlyService(three parameters) - Will return the standard service charge with an added oil change fee, a tire rotation charge, along with a coupon amount that will be deducted from the total cost.

public class AssignmentRedo { 

    // Standard service charge
    private static final double STANDARD_SERVICE_CHARGE = 100.0;

    // Oil change fee
    private static final double OIL_CHANGE_FEE = 69.0;

    // Tire rotation charge
    private static final double TIRE_ROTATION_CHARGE = 45.0;

    // Coupon amount
    private static final double COUPON_AMOUNT = 10.0;

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Yearly Auto Service Cost:");
        System.out.println("=========================");
        System.out.println("");
        System.out.println("Standard Service Cost: $" + yearlyService());
        System.out.println("Standard Service Cost with Oil Change Fee: $" + yearlyService(1));
        System.out.println("Standard Service Cost with Oil Change Fee and Tire Rotation Fee: $" + yearlyService(1, 2));
        System.out.println("Standard Service Cost with Oil Change Fee, Tire Rotation Fee and Coupon Amount: $" + yearlyService(1, 2, 3));
        
        System.out.println("");
        System.out.println("Most Expensive to Least Expensive Service");
        System.out.println("==========================================");
        System.out.println("$" + yearlyService(1,2) + ": Standard service, oil change, and tire rotation");
        System.out.println("$" + yearlyService(1, 2,3) + ": Standard service, oil change, tire rotation, and coupon.");
        System.out.println("$" + yearlyService(1) + ": Standard service and oil change.");
        System.out.println("$" + yearlyService() + ": Standard service");
    }

    public static double yearlyService() {
        return STANDARD_SERVICE_CHARGE;
    }

    public static double yearlyService(double oilChangeFee) {
        return STANDARD_SERVICE_CHARGE + OIL_CHANGE_FEE;
    }

    public static double yearlyService(double oilChangeFee, double tireRotationFee) {
        return STANDARD_SERVICE_CHARGE + OIL_CHANGE_FEE + TIRE_ROTATION_CHARGE;
    }

    public static double yearlyService(double oilChangeFee, double tireRotationFee, double couponAmount) {
        return STANDARD_SERVICE_CHARGE + OIL_CHANGE_FEE + TIRE_ROTATION_CHARGE - COUPON_AMOUNT;
    }
}
