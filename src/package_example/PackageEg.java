package package_example;

import java.util.Scanner;

public class PackageEg {
	public static void main(String[] args) {
	    Scanner a = new Scanner(System.in);
	    System.out.println("Enter username");

	 String userName = a.nextLine();
	    System.out.println("Username is: " + userName);
	    PackageEg p=new PackageEg();
	    p.msg();
	  }

	public void msg() {
		
		
		System.out.println("first package");
	}

}
