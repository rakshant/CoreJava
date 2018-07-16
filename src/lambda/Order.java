package lambda;
enum Status {
	NEW(1),REJECTED(2),ACCEPTED(3),COMPLETED(4);
	private int val;
	Status(int val)
	{
		this.val=val;
	}
	
	public String toString()
	{
		return super.toString();
	}
	public int getVal()
	{
		return val;
	}
}
public class Order
{
	Status status;
	String orderId;
	String name;
	int quantity;
	double price;
	
	public Order(Status s,String oid,String nm,int q,double p)
	{
		status=s;
		orderId=oid;
		name=nm;
		quantity=q;
		price=p;
		
	}
	
	public String toString()
	{
		return "Status "+status+" Order Id "+orderId+" Name "+name+" Quantity "+quantity+" Price "+price;
	}
}