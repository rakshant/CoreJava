package lambda;

import java.util.List;

public class Approach_3 {


	public static void print(List<Order> orders,Criteria c)
	{
		for(Order ord:orders)
		{
			if(c.check(ord))
				
				System.out.println(ord);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOrderData aod=new AddOrderData();
		List<Order> orders=aod.getOrderData();
		print(orders,new Criteria(){
			public boolean check(Order ordr) {
				
				return ordr.price>10000;
			}
			
		});
		
		System.out.println();
		System.out.println();
		print(orders,new Criteria(){
			
			public boolean check(Order ordr) {
				
				return ordr.status==Status.ACCEPTED || ordr.status==Status.COMPLETED ;
			}
		});

}
}
