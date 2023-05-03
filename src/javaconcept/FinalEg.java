package javaconcept;

public class FinalEg {

	final int x = 10;

	  public static void main(String[] args) {
	    FinalEg myObj = new FinalEg();
	   // myObj.x = 25; // will generate an error: cannot assign a value to a final variable
	    System.out.println(myObj.x);
	  }

}
/*
 * If you make any variable as final, you cannot change the value of final variable(It will be constant).
 * If you make any method as final, you cannot override it.
 * If you make any class as final, you cannot extend it.
*/