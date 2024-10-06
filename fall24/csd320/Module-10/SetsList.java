import java.util.*;

public class SetsList {
      public static void main(String [] args) {
         List <Integer>  list = new ArrayList <Integer> ();
         Set <Integer> set = new HashSet <Integer> ();
         
         Integer intObject;
         
         for(int i = 0; i < 100; ++i){
              intObject = new Integer ((int) (Math.random() * 10 + 1));
              list.add(intObject);
              set.add(intObject);
         }
         
         System.out.println("List size = " + list.size()); 
         System.out.println("Set size = " + set.size());
    } 
}