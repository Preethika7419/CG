package inheritance;


	class Superclass {
		   int num = 20;

		  
		   public void display() {
		      System.out.println("This is the display method of superclass");
		   }
		}

		
		public class Subclass extends Superclass {
		   int num = 10;

		 
		   public void display() {
		      System.out.println("This is the display method of subclass");
		   }

		   public void show() {
		      
		      Subclass sub = new Subclass();

		     
		      sub.display();

		      
		      super.display();

		      
		     System.out.println("value of the variable named num in sub class:"+ sub.num);

		     
		      System.out.println("value of the variable named num in super class:"+ super.num);
		   }

		   public static void main(String args[]) {
		      Subclass obj = new Subclass();
		      obj.show();
		   }
		}


