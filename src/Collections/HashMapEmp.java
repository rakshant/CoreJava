package Collections;

import java.util.HashMap;

class Dates{
	int day;
	int month;
	int year;
	public Dates(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	@Override
	public boolean equals(Object obj) {
		 
		 Dates d=(Dates)obj;
		 if(d.day==this.day && d.month!=this.month && d.year!= this.year)
			 return true;
		 else
			 return false;
		
	}
	@Override
	public int hashCode() {
			return 25;
	}

	
	
}
public class HashMapEmp {

	public static void main(String[] args) {
		
		Dates d1 =new Dates(22,5,1994);
		Dates d2 =new Dates(22,4,1995);
				
		HashMap<Dates, String> hm=new HashMap<Dates, String>();
		hm.put(d1,"Alex");
		hm.put(d2,"Yash");
			
		System.out.println(hm.get(d1));
		System.out.println(hm.get(d2));
		
	}

}
