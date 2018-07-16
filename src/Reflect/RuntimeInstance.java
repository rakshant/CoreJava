package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

class Testing {
	static String name = "Hello";

	public Testing() {
			System.out.println(this.name);
	}

	public Testing(String name) {
		this.name = name;
		System.out.println(this.name);
	}

}

public class RuntimeInstance {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class c=Class.forName(args[0]);
		Constructor con[]=c.getDeclaredConstructors();
		
		
		int i=0,j=0;
		
		for(i=0;i<con.length;i++){
			System.out.println(con[i]);
			
			Class call[]=con[i].getParameterTypes();
			if(call.length==0){
				con[i].newInstance();
			}
			else{
				Object initArg[] = new Object[call.length];
				
				Class c1[]=con[i].getParameterTypes();
				for(j=0;j<c1.length;j++){					

						if(c1[j].equals(Boolean.TYPE)){
							
							initArg	[j]=true;			
						}
						else if(c1[j].equals(Character.TYPE)){
							initArg	[j]='a';			
						}
						else if(c1[j].equals(Integer.TYPE)){
							initArg	[j]=1;			
						}
						else if(c1[j].equals(Short.TYPE)){
							initArg	[j]=(short)1;			
						}
						else if(c1[j].equals(Long.TYPE)){
							initArg	[j]=(long)1;			
						}
						else if(c1[j].equals(Byte.TYPE)){
							initArg	[j]=(byte)1;			
						}
						else if(c1[j].equals(Float.TYPE)){
							initArg	[j]=1.1f;			
						}
						else if(c1[j].equals(Double.TYPE)){
							initArg	[j]=1.1;			
						}
						else{
							initArg	[j]=new String("Hello");
						}
					
	
				con[i].newInstance(initArg);
				}
			
			}
		
		
		}
}
}
