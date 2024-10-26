public class Main {
    public static void main(String[] args) {
        // Create a Person object with name "John Doe" and age 30
        Person person1 = new Person("John Doe", 30);
        
        // Create another Person object with name "Jane Doe" and age 25
        Person person2 = new Person("Jane Doe", 25);
        
        int totalAge = person1.getAge() + person2.getAge();
        System.out.println("Total age: " + totalAge);  // prints 55
    }
}