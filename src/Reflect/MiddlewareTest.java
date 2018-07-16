package Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Test {

	public static void getName(String name) {
		System.out.println(name.toLowerCase());
	}


}

class Middleware {

	public static void invokeMethod(String className, String methodName,
			Class[] paramTypes, Object[] paramValues)
			throws Exception {

		Class c = Class.forName(className);
		Method m = c.getMethod(methodName, paramTypes);

		// if(c.getModifiers()==Modifier.STATIC){
		if (Modifier.isStatic(m.getModifiers())) {
			System.out.println("Hello1");
			m.invoke(null, paramValues);
		} 
		else {
			System.out.println("Hello2");
			m.invoke(c.newInstance(), paramValues);
		}

	}
}

public class MiddlewareTest {

	public static void main(String[] args) throws Exception,
			InstantiationException {
		// TODO Auto-generated method stub
		Class[] paramTypes = new Class[1];
		paramTypes[0] = Class.forName("java.lang.String");

		Object[] paramValues = new Object[1];
		paramValues[0] = "Rakshant";
		Middleware.invokeMethod("Reflect.Test", "getName", paramTypes,
				paramValues);
		
	
	}

}
