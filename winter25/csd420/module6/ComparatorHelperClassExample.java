// Example from geeks for geeks 
import java.util.*;

// Define the Student class
class Student 
{
    String name;
    Integer age;

      // Constructor
    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

      // Method to print student
      // details in main()
    @Override
    public String toString() {
        return name + " : " + age;
    }
}

// Comparator in a Helper Class
class StudentSortingComparator implements Comparator<Student> 
{
    
      // Compare first by name, then by age
    public int compare(Student customer1, Student customer2) {
        
          // Compare by name first
        int NameCompare = customer1.getName().compareTo(
                                  customer2.getName());
        
        // If names are the same, compare by age
        int AgeCompare = customer1.getAge().compareTo(
                                  customer2.getAge());
        
        // Return the result: first by name, second by age
        return (NameCompare == 0) ? AgeCompare : NameCompare;
    }
}

public class ComparatorHelperClassExample 
{
    public static void main(String[] args) 
    {
        List<Student> students = new ArrayList<>();
      
        students.add(new Student("Ajay", 27));
        students.add(new Student("Sneha", 23));
        students.add(new Student("Simran", 37));
        students.add(new Student("Ankit", 22));
          students.add(new Student("Anshul", 29));
          students.add(new Student("Sneha", 22));
      
          // Original List
        System.out.println("Original List ");

        // Iterating List
        for (Student it : students) {
            System.out.println(it);
        }
      
          System.out.println();

        // Sort students by name, then by age
          // using the CustomerSortingComparator
        Collections.sort(students, new StudentSortingComparator());

        // Display message only
        System.out.println("After Sorting ");

        // Iterating using enhanced for-loop
        // after Sorting ArrayList
        for (Student it : students) {
            System.out.println(it);
        }
    }
}