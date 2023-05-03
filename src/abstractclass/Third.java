package abstractclass;

public class Third {
	public static void main(String[] args) {
	    // create an object of the Second class (which inherits attributes and methods from abstract class First)
	    Second myObj = new Second();

	    System.out.println("Name: " + myObj.fname);
	    System.out.println("Age: " + myObj.age);
	    System.out.println("Graduation Year: " + myObj.graduationYear);
	    myObj.study(); // call abstract method
	  }

}


/*The abstract keyword is a non-access modifier, used for classes and methods.

Class: An abstract class is a restricted class that cannot be used to
 create objects (to access it, it must be inherited from another class).

Method: An abstract method can only be used in an abstract class, and it does not have a body. 
The body is provided by the subclass (inherited from).
*/