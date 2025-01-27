import java.util.ArrayList;
import java.util.LinkedList;

public class Lists {
    public static void main(String[] args) {
        // ArrayList Example
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        
        System.out.println("\nArrayList using foreach loop:");
        for (String fruit : list1) {
            System.out.println(fruit);
        }

        // LinkedList Example
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Orange");
        list2.add("Grape");
        
        System.out.println("\nLinkedList using foreach loop:");
        for (String fruit : list2) {
            System.out.println(fruit);
        }
    }
}