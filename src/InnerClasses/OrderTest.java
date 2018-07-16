package InnerClasses;

enum Status{ 
	NEW(1), REJECTED(2), ACCEPTED(3), COMPLETED(4);
	int statusID;
	private Status(int statusID) {
		this.statusID=statusID;		
	}
	public int getValue(){
		return statusID;		
	}
	public String toString(){
		return "Status-"+statusID;
	}
};


class Order{
	String orderName;
	int quantity;
	int price;
	int orderID;
	Status status;
	
	public Order(String orderName, int quantity, int price, int orderID,
			Status status) {
		super();
		this.orderName = orderName;
		this.quantity = quantity;
		this.price = price;
		this.orderID = orderID;
		this.status = status;
	}	
	

	
}

public class OrderTest {

	public static void main(String[] args) {
		Order o=new Order("Bat", 1, 1000, 101,Status.ACCEPTED);
		System.out.println(o.status.getValue());
		System.out.println(o.status);
	
		
		
	}

}
