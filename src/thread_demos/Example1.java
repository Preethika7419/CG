package thread_demos;
class Square1 extends Thread{
	public void run() {
		for(int i=1;i<=5;i++)
		{
			int sq=0;
			sq=i*i;
			System.out.println("Square of "+i+" is"+sq);
			try{
				Thread.sleep(1000);
			}
			catch(Exception e) {
			}
		}
	}
}
	

class Cube1 extends Thread{
	public void run() {
		for(int i=1;i<=5;i++)
		{
			int cu=0;
			cu=i*i*i;
			System.out.println("Cube of "+i+" is"+cu);
			try{
				Thread.sleep(1000);
			}
			catch(Exception e) {
			}
		}
	}
	
}


public class Example1 {

	public static void main(String[] args)  throws Exception{
		Square1 obj1=new Square1();
		Cube1 obj2=new Cube1();
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		System.out.println(t1.getState());
		t1.start();
		//t1.yield();
		
		System.out.println(t1.getState());
		System.out.println(t1.getName());
		t1.setName("preethi");
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
		
		System.out.println(t1.getId());
		t2.start();
		t1.setPriority(3);
		System.out.println(t1.getPriority());
		//t1.stop();
		System.out.println(t1.isAlive());
		//t1.suspend();
		//System.out.println("suspend");
		
		System.out.println(t1.getState());
		
		t2.join();
		//t1.resume();
		System.out.println(t1.isAlive());
		
		System.out.println("bye");
		t1.join();
		System.out.println(t1.getState());
		System.out.println("bye2");
	}

}
