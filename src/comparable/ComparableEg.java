package comparable;

import java.util.ArrayList;
import java.util.Collections;

class Author implements Comparable<Author> {

	  String firstName;
	  String lastName;
	  String bookName;
	  Author(String first, String last, String book){
		this.firstName = first;
		this.lastName = last;
		this.bookName = book;
	  }
		
	
	  
	  public int compareTo(Author au){
	     
	     int last = this.lastName.compareTo(au.lastName);
	    
	     return last == 0 ? this.firstName.compareTo(au.firstName) : last;
	  }
	}

public class ComparableEg{  
	   public static void main(String args[]){  
	     
	      ArrayList<Author> al=new ArrayList<Author>(); 
	      al.add(new Author("Jones","Miller", "Tropic of Cancer"));  
	      al.add(new Author("Harini","Jagathish", "Brown Girl in the Ring"));
	      al.add(new Author("Daman","Miller", "300"));
	      al.add(new Author("Deborah","Potter", "Sky Boys"));
	      al.add(new Author("Madhu","Martin", "Song of Ice and Fire"));
	      
	     
	      Collections.sort(al);  
	      for(Author str:al){  
	    	  System.out.println(str.firstName+" "+
	          str.lastName+" "+"Book: "+str.bookName);  
	      } 
	   }  
	}  