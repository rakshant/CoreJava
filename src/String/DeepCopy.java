package String;


class DeepDate implements Cloneable{
	int day;
	int month;
	int year;
	public DeepDate() {
		// TODO Auto-generated constructor stub
	}
	public DeepDate(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	public String toString(){
			return "Date is-"+day+"/"+month+"/"+year;
	}
	public Object clone() throws CloneNotSupportedException{
		return (DeepDate) super.clone();
	}

	
}

class Emp implements Cloneable{
	int id;
	DeepDate d;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(int id,DeepDate d){
		this.id=id;
		this.d=d;

	}
	public Object clone() throws CloneNotSupportedException{
		
		
		Emp p=(Emp) super.clone();
		p.d=(DeepDate)this.d.clone();
		return p;
			
}
}


public class DeepCopy {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		
		DeepDate d1=new DeepDate(21,02, 2015);
		Emp e1=new Emp(10,d1);
		Emp e2=(Emp) e1.clone();
		System.out.println("Date d1-"+e1);
		System.out.println("Date d2-"+e2);
		
		if(e1.hashCode()==e2.hashCode())
			System.out.println("Shallow copy");
		if(e1.d.hashCode()!=e2.d.hashCode())
			System.out.println("Deep Copy");

	}

}
