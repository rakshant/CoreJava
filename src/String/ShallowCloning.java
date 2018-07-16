package String;


class Date implements Cloneable{
	int day;
	int month;
	int year;
	public Date() {

	}
	public Date(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}

	public Date clone() throws CloneNotSupportedException{
		
		return (Date) super.clone();
		
	}
	
}



public class ShallowCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date d1=new Date(21,02, 2015);
		Date d2=d1.clone();
		System.out.println("Date d1-"+d1);
		System.out.println("Date d2-"+d2);

	}

}
