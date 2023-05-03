package exception;

public class Eg2 {
	
	    
	    static int divide(int a, int b){
	          
	        int i = a/b; 
	          
	        return i;
	    }
	      
	   
	    static int computeDivision(int a, int b) {
	        int res =0;
	        try
	        {
	          res = divide(a,b);
	        }
	       
	        catch(NumberFormatException ex)
	        {
	           System.out.println("NumberFormatException is occured"); 
	        }
	        return res;
	    }
	      
	    
	    public static void main(String args[]){
	          
	        int a = 1;
	        int b = 0;
	          
	        try
	        {
	            int i = computeDivision(a,b);
	          
	        }
	          
	       
	        catch(ArithmeticException ex)
	        {
	           
	            System.out.println(ex.getMessage());
	        }
	    }
	}


