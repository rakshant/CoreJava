package Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExpHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int a=5/0;
			int b[]=new int[2];
			System.out.println(b[3]);
			try{
				FileInputStream fis=new FileInputStream("a.txt");
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}catch(ArithmeticException e){
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		finally{
			System.out.println("Bye Bye");
		}

	}

}
