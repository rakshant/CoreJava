package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectDemo {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class c=Class.forName(args[0]);
		Constructor con[]=c.getDeclaredConstructors();
		Field f[]=c.getDeclaredFields();
		Method m[]=c.getDeclaredMethods();
		
		int i=0;
		for(i=0;i<con.length;i++){
			System.out.println(con[i]);
		}
		
		for(i=0;i<f.length;i++){
			System.out.println(f[i]);
		}
		
		
		for(i=0;i<m.length;i++){
			System.out.println(m[i]);
		}
		
		
		

	}

}
