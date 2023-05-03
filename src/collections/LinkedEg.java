package collections;


import java.util.ArrayList;

import java.util.LinkedList;



public class LinkedEg {
	
	   public static void main(String args[]){

	     LinkedList<String> list=new LinkedList<String>();

	     
	     list.add("Apple");
	     list.add("Orange");
	     list.add("Guava");
	     list.add("Jackfriut");
	     list.add("Watermelon");
	     list.add("Papaya");
	     System.out.println(list);

	     
	     list.addFirst("Pineapple");
	     
	     list.addLast("Mango");
	     
	     list.add(2, "Grapes");
	     
	     System.out.println("\n"+list);
	     
	     System.out.println("\nSize of the list "+list.size());
	     
	     list.set(2, "Mosambi");

	    System.out.println("\n"+list);
	    System.out.println( "\nSub list"+list.subList(2, 5));
	    
	    
	    list.removeFirst();
	    System.out.println("\nFirst Element removedt"+list);
	    
	    list.removeLast();
	    System.out.println("\nLast Element removed"+list);
	    
	    list.remove(1);
	    System.out.println("\n"+list);
	    
	    list.remove("Papaya");
	    System.out.println("\n"+list);
	    
	    list.poll();
	    System.out.println("\n"+list);
	    
	   Object q= list.pollLast();
	   System.out.println("Polled element:"+q);
	   
	    System.out.println("\n"+list);
	    
	    System.out.println("\nIndex Position"+list.indexOf("Guava"));
	    
	    Object str1=list.clone();
	    System.out.println("Cloned list"+str1);
 
	    ArrayList<String> arrlist=new ArrayList<String>();
	    arrlist.addAll(list);
	    arrlist.addAll(2, list);
	    for(String str:arrlist)
	    	System.out.println(str);
	     
	   } 
	} 


