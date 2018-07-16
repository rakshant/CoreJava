package String;

public class MutableTest {

	public static void main(String[] args) {
		String s1="Hello";
		String s2=new String("Hello");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		if(s1==s2)
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		
		
		
		StringBuffer sb=new StringBuffer("Hi");		
		System.out.println(sb+ "  "+sb.hashCode());
		
		sb.append(" Rakshant");
		System.out.println(sb+"  "+sb.hashCode());
		
		
		System.out.println("Hi".hashCode());
		System.out.println("Hi Rakshant".hashCode());
		

	}

}
