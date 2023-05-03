package abstractclass;

abstract class First {
	public String fname = "John";
	  public int age = 24;
	  public abstract void study(); // abstract method

}







/*The abstract keyword is a non-access modifier, used for classes and methods.

Class: An abstract class is a restricted class that cannot be used to
 create objects (to access it, it must be inherited from another class).

Method: An abstract method can only be used in an abstract class, and it does not have a body. 
The body is provided by the subclass (inherited from).
*/