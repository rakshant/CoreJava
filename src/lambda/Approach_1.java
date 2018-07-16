package lambda;

import java.util.List;

public class Approach_1 {

	public static void orderPrice(List<Order> orders)
	{
		for(Order o:orders)
		{
			if(o.price>10000)
				System.out.println(o);
		}
	}
	
	public static void orderStatus(List<Order> orders)
	{
		for(Order o:orders)
		{
			if(o.status==Status.ACCEPTED || o.status==Status.COMPLETED )
				System.out.println(o);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddOrderData aod=new AddOrderData();
		List<Order> orders=aod.getOrderData();
		orderPrice(orders);
		
		System.out.println();
		System.out.println();
		
		orderStatus(orders);
		
	}

}
