package lambda;


import java.util.ArrayList;
import java.util.List;

public class AddOrderData {

	public List<Order> orders;
	public List<Order> getOrderData()
	{
		orders=new ArrayList<Order>();
		orders.add(new Order(Status.NEW, "A101", "Name1", 3, 5000));
		orders.add(new Order(Status.ACCEPTED, "B101", "Name1", 3, 40000));
		orders.add(new Order(Status.REJECTED, "C101", "Name1", 3, 60000));
		orders.add(new Order(Status.COMPLETED, "D101", "Name1", 3, 10000));
		
		return orders;
	}
}
