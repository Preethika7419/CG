package polymorphism;


	class Multiple {
		  
	   
	    static int Multiply(int a, int b)
	    {
	        return a * b;
	    }
	  
	   
	    static double Multiply(double a, double b)
	    {
	        return a * b;
	    }
	}
	  
	class Eg2 {
	    public static void main(String[] args)
	    {
	  
	        System.out.println(Multiple.Multiply(2, 4));
	  
	        System.out.println(Multiple.Multiply(5.5, 6.3));
	    }
	}

