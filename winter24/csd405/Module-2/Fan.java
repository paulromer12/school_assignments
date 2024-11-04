// Paul Romer, Module 2 Programming Assignment, Nov 3 2024

import java.util.ArrayList;

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

    // Getter methods
    public int getSpeed() {
        return this.speed;
    }

    public boolean isOn() {
        return this.on;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    // Setter methods
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
}

class UseFans {

    // Method to display a collection of Fan instances without using toString()
    public void displayFans(ArrayList<Fan> fans) {
        for (Fan fan : fans) {
            displayFan(fan);
            System.out.println("----------");
        }
    }

    // Method to display details of a single Fan instance without using toString()
    public void displayFan(Fan fan) {
        String speed = switch (fan.getSpeed()) {
            case Fan.SLOW -> "Slow";
            case Fan.MEDIUM -> "Medium";
            case Fan.FAST -> "Fast";
            default -> "Stopped";
        };
        
        System.out.println("Fan Details:");
        System.out.println("Speed: " + speed);
        System.out.println("On: " + (fan.isOn() ? "Yes" : "No"));
        System.out.println("Radius: " + fan.getRadius());
        System.out.println("Color: " + fan.getColor());
    }

    public static void main(String[] args) {
        // Create some Fan instances
        System.out.println();
        Fan fan1 = new Fan(); // Default settings
        Fan fan2 = new Fan(Fan.FAST, true, 8.0, "blue");  // Custom settings
        Fan fan3 = new Fan(Fan.MEDIUM, false, 5.5, "green");  // Another custom fan

        // Add fans to a collection
        ArrayList<Fan> fans = new ArrayList<>();
        fans.add(fan1);
        fans.add(fan2);
        fans.add(fan3);

        // Create an instance of UseFans and display fan information
        UseFans useFans = new UseFans();
        
        System.out.println("Displaying all fans in collection:");
        useFans.displayFans(fans);
    }
}