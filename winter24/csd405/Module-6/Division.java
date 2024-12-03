// Paul Romer, Module 6 programming assignment, CSD405 

// Create an abstract Division class with fields for a company's division name and account number, and an abstract display() method that will be defined in the subclasses.
// Use a constructor in the superclass that requires values for both fields.

public abstract class Division {
    protected String name;
    protected int accountNumber;

    public Division(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public abstract void display();
}