// Paul Romer, Module 6 programming assignment, CSD405 

// The DomesticDivision class includes a field for the state in which the division is located and a constructor that requires all fields when created.

public class DomesticDivision extends Division {
    protected String state;

    public DomesticDivision(String name, int accountNumber, String state) {
        super(name, accountNumber);
        this.state = state;
    }

    @Override
    public void display() {
        System.out.println("Domestic Division:");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("State: " + state);
    }
}
