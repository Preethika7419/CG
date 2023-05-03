package polymorphism;


	class Multiplication {
		  
	    // Method with 2 parameter
	    static int Multiply(int a, int b)
	    {
	        return a * b;
	    }
	  
	    // Method with the same name but 3 parameter
	    static int Multiply(int a, int b, int c)
	    {
	        return a * b * c;
	    }
	}
	  
	class Eg3 {
	    public static void main(String[] args)
	    {
	        System.out.println(Multiplication.Multiply(2, 4));
	  
	        System.out.println(Multiplication.Multiply(2, 7, 3));
	    }
	}


