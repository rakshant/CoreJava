package String;

public class StringBanner {

	public static void main(String[] args) throws InterruptedException {
		StringBuffer sb=new StringBuffer("Welcome to Java");
		System.out.println(sb);
		while(true){
			char c=sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(c);
			System.out.println(sb);
			Thread.sleep(500);
			
		}

	}

}
