// Write a program with a class titled Fan. This class is to contain:
// Four constants named STOPPED, SLOW, MEDIUM, and FAST. The constants are to hold the values of 0, 1, 2, and 3 respectively.
// A private field named speed that holds one of the constant values with the default being STOPPED.
// A private Boolean field titled on that specifies whether the fan is on or off.
// A private field named radius that holds the radius of the fan with a default value of 6.
// A String field that holds the color, with the default being white.
// Setter and getter methods for all mutable fields.
// A no-argument constructor that sets all fields with a default value.
// A constructor taking arguments and setting values.
// Write a toString() method that returns a description of the Fans state.
// Write test code that creates two instances of the Fan class, one using the default constructor and the other using the argument constructor. Write code that displays the functionality of the Fan class methods.

public class Fan {
    // Constants
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Private fields
    private int speed = STOPPED; // Default is stopped
    private boolean on; // Whether the fan is on or off
    private double radius = 6.0; // Default radius of 6 inches
    private String color = "white"; // Default color

    /**
     * No-argument constructor to set default values for all fields.
     */
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6.0;
        this.color = "white";
    }

    /**
     * Constructor with arguments to set custom values for all fields.
     *
     * @param speed   the fan's speed (STOPPED, SLOW, MEDIUM, or FAST)
     * @param on      whether the fan is on or off
     * @param radius  the fan's radius in inches
     * @param color   the fan's color
     */
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
    @Override
    public String toString() {
        return "Fan{" +
                "speed=" + speed +
                ", on=" + on +
                ", radius=" + radius +
                ", color='" + color + '\\'' +
                '}';
    }

    public static void main(String[] args) {
        // Create two instances of the Fan class
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(FAST, true, 8.0, "blue");

        System.out.println("Fan 1 (default constructor):");
        System.out.println(fan1.toString());

        System.out.println("\\nFan 2 (argument constructor):");
        System.out.println(fan2.toString());

        // Display the functionality of the Fan class methods
        fan2.setOn(false);
        fan2.setSpeed(SLOW);
        fan2.setColor("red");

        System.out.println("\\nUpdated fan2:");
        System.out.println(fan2.toString());
    }
}