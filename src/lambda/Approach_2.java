package lambda;

import java.util.List;

public class Approach_2 {

	class OrderPrice implements Criteria
	{

		@Override
		public boolean check(Order o) {
			
			return o.price>10000;
		}
		
		
	}
	
	class OrderStatus implements Criteria
	{

		@Override
		public boolean check(Order o) {
			
			return o.status==Status.ACCEPTED || o.status==Status.COMPLETED ;
		}
		
	}
	
	public static void print(List<Order> orders,Criteria c)
	{
		for(Order o:orders)
		{
			if(c.check(o))
				
				System.out.println(o);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOrderData aod=new AddOrderData();
		List<Order> orders=aod.getOrderData();
		Approach_2 obja2=new Approach_2();
		Criteria c=obja2.new OrderPrice();
		print(orders,c);
		
		System.out.println();
		System.out.println();
		
		Criteria c1=obja2.new OrderStatus();
		print(orders,c1);
	}

}
