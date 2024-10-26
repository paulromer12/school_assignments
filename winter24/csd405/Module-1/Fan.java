// Paul Romer, Module 1 Programming Assignment, Oct 26 2024

// Creates a Fan class with no-argument and argument constructors, including getter and setter methods, and toString() method to return the Object's state. Includes a main method that creates 2 instances of the fan class, one without arguments and one with arguments. Then updates the fan2 instance of the fan class using the setter methods. 

public class Fan {
    // Constants
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Private fields
    private int speed = STOPPED; 
    private boolean on;
    private double radius = 6.0;
    private String color = "white";

    // No-argument constructor to set default values for all fields.
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6.0;
        this.color = "white";
    }

    // Constructor with arguments to set custom values for all fields.
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    // Getter methods for all fields
    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    // Setter methods for mutable fields
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString() method to return a description of the fan's state
    public String toString() {
        return "Fan{" +
                "speed=" + speed +
                ", on=" + on +
                ", radius=" + radius +
                ", color='" + color  + "'" +
                '}';
    }

    public static void main(String[] args) {
        // Create two instances of the Fan class
        Fan fan1 = new Fan(); // No-argument default constructor
        Fan fan2 = new Fan(FAST, true, 8.0, "blue");  // Argument Constructor

        // Display fan1 state
        System.out.println();
        System.out.println("Fan 1 (default constructor):");
        System.out.println(fan1.toString());

        // Display fan2 state
        System.out.println();
        System.out.println("Fan 2 (argument constructor):");
        System.out.println(fan2.toString());

        // Change the fan2 using setter methods
        fan2.setOn(false);
        fan2.setSpeed(SLOW);
        fan2.setColor("red");

        // Display new fan2 state
        System.out.println();
        System.out.println("Updated Fan 2:");
        System.out.println(fan2.toString());
    }
}