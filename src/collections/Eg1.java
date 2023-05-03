package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Eg1 {
	
	  
	   public static void main(String args[]){  
	      ArrayList<String> alist=new ArrayList<String>();  
	      alist.add("John");
	      alist.add("Ram");
	      alist.add("Priya");
	      alist.add("Prasad");
	      alist.add("Richard");
	      alist.add("Tom");
	  
	      
	      System.out.println(alist);
	  
	     
	      alist.add(3, "preethi");
	  
	     
	      System.out.println(alist);
	      alist.set(3, "element");
	      System.out.println(alist);
	      alist.remove(2);
	      System.out.println(alist);
	      alist.remove("elements");
	      System.out.println(alist);
	      for(String str:alist)  
	          System.out.println(str);  
	      System.out.println("size of the arraylist "+alist.size());
	      Collections.sort(alist);
	      System.out.println("After Sorting"+alist);
	      Collections.reverse(alist);
	      System.out.println("Reverse Sorting"+alist);
	      System.out.println("Element Present: "+alist.contains("tom"));
	      System.out.println("Index position:"+alist.get(2));
	      System.out.println(alist.indexOf("Tom"));
	      //alist.clear();
	      //System.out.println(alist);
	      
	      
	      ArrayList<String> obj = new ArrayList<String>(Arrays.asList("Pratap", "Peter", "Harsh"));
	    		  System.out.println("Initialized Array:"+obj);
	    		  obj.add("kishore");
	    		  System.out.println(obj);
	    		  
	    	alist.addAll(obj);
	    	System.out.println(alist);
	      
	   }  
	}


