// Paul Romer, Module 6 programming assignment, CSD405 

// The InternationalDivision class includes a field for the country in which the division is located, a field for the language spoken, and a constructor that requires all fields when created.

public class InternationalDivision extends Division {
    protected String country;
    protected String language;


    public InternationalDivision(String name, int accountNumber, String country, String language) {
        super(name, accountNumber);
        this.country = country;
        this.language = language;
    }

    @Override
    public void display() {
        System.out.println("International Division:");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Country: " + country);
        System.out.println("Language: " + language);
    }
}
