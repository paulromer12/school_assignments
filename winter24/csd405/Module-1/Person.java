public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter method to retrieve the person's name
    public String getName() {
        return name;
    }

    // Setter method to set the person's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method to retrieve the person's age
    public int getAge() {
        return age;
    }

    // Setter method to set the person's age
    public void setAge(int age) {
        this.age = age;
    }
}