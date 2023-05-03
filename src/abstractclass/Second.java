package abstractclass;

public class Second extends First{
	public int graduationYear = 2020;
	// the body of the abstract method is provided here
	  public void study() { 
	    System.out.println("Studying all day long");
	  }

	
	

}

/*The abstract keyword is a non-access modifier, used for classes and methods.

Class: An abstract class is a restricted class that cannot be used to
 create objects (to access it, it must be inherited from another class).

Method: An abstract method can only be used in an abstract class, and it does not have a body. 
The body is provided by the subclass (inherited from).
*/