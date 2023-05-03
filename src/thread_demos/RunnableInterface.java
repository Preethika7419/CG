package thread_demos;
class Hi1 implements Runnable{
	synchronized public void run() {
		for(int i=1;i<=5;i++)
		{
			System.out.println("Hi");
			try{
				Thread.sleep(1000);
			}
			catch(Exception e) {
			}
		}
	}
}
	

class Hello1 implements Runnable{
	synchronized public void run() {
		for(int i=1;i<=5;i++)
		{
			System.out.println("Hello");
			try{
				Thread.sleep(1000);
			}
			catch(Exception e) {
			}
		}
	}
	
}

public class RunnableInterface {

	public static void main(String[] args)  throws Exception{
		Runnable obj1=new Hi1();
		Runnable obj2=new Hello1();
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
