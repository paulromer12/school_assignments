// Java Program Implementing HashMap
import java.util.HashMap;
import java.util.Map;

public class MapCreationExample {
    
      public static void main(String[] args) 
    {
      
        // Create a Map using HashMap
        Map<Integer, String> map = new HashMap<>();

		// Add key value pairs to the map 
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		// Displaying the Map
        System.out.println("Map elements: " + map);

        // Displaying the value from key 2
        System.out.println(map.get(2));

        // Remove an element from the map
        map.remove(3);
        System.out.println(map);

        // Clear the map
        map.clear();
        System.out.println(map);
    }
}