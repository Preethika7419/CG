package collectionEg;
import java.util.HashSet;
import java.util.Iterator;
public class HashEg {
   public static void main(String args[]) {
      
      HashSet<String> hset =  new HashSet<String>();

     
      hset.add("Apple");
      hset.add("Mango");
      hset.add("Grapes");
      hset.add("Orange");
      hset.add("Fig");
     
      hset.add("Apple");
      hset.add("Mango");
    
      hset.add(null);
      hset.add(null);

      
      System.out.println(hset);
      
      Iterator<String> it = hset.iterator();
      while(it.hasNext()){
         System.out.println(it.next());
      }
      
      for (String temp : hset) {
          System.out.println(temp);
       }
      
      String[] array = new String[hset.size()];
      hset.toArray(array);
  
    
      System.out.println("Array elements: ");
      for(String temp : array){
         System.out.println(temp);
      }
      hset.clear();
      System.out.println(hset);
    }
}