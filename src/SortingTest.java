interface Sortable{
	boolean compare(Sortable s);
}

class Circle implements Sortable{
	
	int radius;
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	public Circle(int radius){
		this.radius=radius;
	}


	@Override
	public boolean compare(Sortable s) {
		// TODO Auto-generated method stub
		
		if(this.radius > ((Circle) s).radius)
			return true;
		else
			return false;
		
	}
	
}

class Emp implements Sortable{
	
	String name;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(String name){
		this.name=name;
	}

	@Override
	public boolean compare(Sortable s) {
		// TODO Auto-generated method stub
		if(this.name.compareTo(((Emp) s).name)>0 )
			return true;
		else
			return false;
			
	}
	
}


public class SortingTest {
	
	public static void sortAll(Sortable[] sort){
		Sortable temp;
		
		for(int i=0;i<sort.length;i++){
			for(int j=i+1;j<sort.length;j++){
				
				if(sort[i].compare(sort[j])){
					temp=sort[i];
					sort[i]=sort[j];
					sort[j]= temp;
				}
			}
		}
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sortable s1[]=new Sortable[4];
		s1[0]=new Circle(5);
		s1[1]=new Circle(1);
		s1[2]=new Circle(9);
		s1[3]=new Circle(2);
		
		Sortable s2[]=new Emp[4];
		s2[0]=new Emp("Aakash");
		s2[1]=new Emp("harshal");
		s2[2]=new Emp("Amit");
		s2[3]=new Emp("Suyash");
		
		System.out.println("Circle");
		SortingTest.sortAll(s1);
		for(int i=0;i<s1.length;i++){
			System.out.println(((Circle)s1[i]).radius);
		}
		System.out.println("Employees");
		SortingTest.sortAll(s2);
		for(int i=0;i<s2.length;i++){
			System.out.println(((Emp)s2[i]).name);
		}
		
		

	}

}
