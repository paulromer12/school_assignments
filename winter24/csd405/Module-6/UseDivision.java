// Paul Romer, Module 6 programming assignment, CSD405 

// Create two subclasses named InternationalDivision and DomesticDivision.
// Write an application named UseDivision that creates two instances of each of these concrete classes (4 total instances).
// Save the files as: Division, InternationalDivision, DomesticDivision, and UseDivision.

public class UseDivision {
    public static void main(String[] args) {
        // Create two instances of InternationalDivision
        InternationalDivision intDiv1 = new InternationalDivision("International Division 1", 1234, "USA", "English");
        InternationalDivision intDiv2 = new InternationalDivision("International Division 2", 5678, "Argentina", "Spanish");

        // Create two instances of DomesticDivision
        DomesticDivision domDiv1 = new DomesticDivision("Domestic Division 1", 9012, "California");
        DomesticDivision domDiv2 = new DomesticDivision("Domestic Division 2", 3456, "New York");

        // Display information about each division
        intDiv1.display();
        intDiv2.display();
        System.out.println();

        domDiv1.display();
        domDiv2.display();
    }
}