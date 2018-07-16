package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaceTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Supplier<Long> s=() -> System.currentTimeMillis();
		System.out.println(s.get());	
		System.out.println(s.get());
		
		List<String> list=new ArrayList<String>();
		Consumer<String> c=(String name)-> list.add(name);
		c.accept("Hi");
		c.accept("Hello");		
		
		for(String name:list)
		{
			System.out.println(name);
		}
		
		Function<String,String> f=(String a)->a+"aaa";
		System.out.println(f.apply("Hi"));
	}

}
