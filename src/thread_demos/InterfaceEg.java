package thread_demos;

class Fibonacci implements Runnable
{
	public void run() {
	int a=0;
	int b=1;
	int c;
	
	for(int i=0;i<=10;i++) {
		
		System.out.println(a);
		c=a+b;
		a=b;
		b=c;
	}
	
}
	


}
public class InterfaceEg {
	public static void main(String args[]) {
		Runnable obj= new Fibonacci();
		Thread t1=new Thread(obj);
		t1.start();
	}
	

}
