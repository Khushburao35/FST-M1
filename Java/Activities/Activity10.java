package Activity;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
 
        hs.add("Q");
        hs.add("C");
        hs.add("E");
        hs.add("B");
        hs.add("D");
        hs.add("A");
        
        System.out.println("HashSet 1: " + hs);        
        System.out.println("HashSet 1 Size: " + hs.size());
        
       hs.remove("Q");

       System.out.println("Checking if Q is present: " + hs.contains("Q"));
       
       if(hs.remove("Q")) {
        	System.out.println("Removed from the Set");
        } else {
        	System.out.println("Not present in the Set");
        }
        
        System.out.println("Updated HashSet: " + hs);
    }
}