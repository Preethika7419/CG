package exception;

public class Example2{  
	   int division(int a, int b) throws ArithmeticException{  
		int t = a/b;
		return t;
	   }  
	   public static void main(String args[]){  
		Example2 obj = new Example2();
		try{
		   System.out.println(obj.division(15,0));  
		}
		catch(ArithmeticException e){
		   System.out.println("You shouldn't divide number by zero");
		}
	   }  
	}
