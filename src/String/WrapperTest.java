package String;

import java.util.Scanner;

public class WrapperTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Give a string name");
		String s = sc.nextLine();

		if (s.equals("true") || s.equals("false")) {
			boolean b = Boolean.parseBoolean(s);
			System.out.println("Its boolean-" + b);
		}
		


	}

}
