package inheritance;

 class calculate {
	
		   int z;
			
		   public void addition(int x, int y) {
		      z = x + y;
		      System.out.println("The sum of the given numbers:"+z);
		   }
			
		   public void Subtraction(int x, int y) {
		      z = x - y;
		      System.out.println("The difference between the given numbers:"+z);
		   }
		}


		public class Eg1 extends calculate {
		   public void multiplication(int x, int y) {
		      z = x * y;
		      System.out.println("The product of the given numbers:"+z);
		   }
			
		   public static void main(String args[]) {
		      int a = 20, b = 10;
		      Eg1 eg = new Eg1();
		      eg.addition(a, b);
		      eg.Subtraction(a, b);
		      eg.multiplication(a, b);
		   }
		}


