package javaconcept;

public class StringEg {

	public static void main(String[] args) {
		System.out.println("Hello world");
		String s=1+2+"str"+2+1;
		String e=""+2+1;
		String r=2+1+"";
		System.out.println(s+" "+e+" "+r);
		
		String s1=new String("preethi");
		String s2=new String("preethi");
		String s3=s1;
		System.out.println(s1.toString());
		System.out.println(s1.hashCode());
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		
		System.out.println(s1.getClass());
		int w;
		System.out.println();
	

	}

}
