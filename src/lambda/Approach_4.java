package lambda;

import java.util.List;
import java.util.function.Predicate;

public class Approach_4 {

	public static void print(List<Order> orders,Predicate<Order> p)
	{
		for(Order o:orders)
		{
			if(p.test(o))
				
				System.out.println(o);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOrderData aod=new AddOrderData();
		List<Order> orders=aod.getOrderData();
		Approach_2 obja2=new Approach_2();		
		print(orders,(Order o)-> o.price>10000);
		System.out.println();
		print(orders,(Order o)-> o.status==Status.ACCEPTED || o.status==Status.COMPLETED );
}
}