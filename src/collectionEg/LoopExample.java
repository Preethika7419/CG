package collectionEg;
import java.util.*;
public class LoopExample {
   public static void main(String[] args) {

      ArrayList<Integer> arrlist = new ArrayList<Integer>();
      arrlist.add(14);
      arrlist.add(7);
      arrlist.add(39);
      arrlist.add(40);

     
      System.out.println("For Loop");
      for (int i = 0; i < arrlist.size(); i++) { 		      
          System.out.println(arrlist.get(i)); 		
      }   		

    
      System.out.println("Advanced For Loop"); 		
      for (Integer num : arrlist) { 		      
           System.out.println(num); 		
      }

      	
      System.out.println("While Loop"); 		
      int count = 0; 		
      while (arrlist.size() > count) {
	 System.out.println(arrlist.get(count));
         count++;
      }

      
      System.out.println("Iterator");
      Iterator i = arrlist.iterator();
      while (i.hasNext()) {
         System.out.println(i.next());
      }
   }
}

