package Collections;

import java.util.HashMap;

class Employee{
	int id;
	public Employee(int id) {
		super();
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 20;
	}
}
public class EmpTest {

	public static void main(String[] args) {
		HashMap<Employee, String> hm=new HashMap<Employee, String>();
		Employee e1=new Employee(1);
		Employee e2=new Employee(1);		
		Employee e3=new Employee(1);
		
		hm.put(e1, "Tom");
		hm.put(e2, "Alex");	
		
		System.out.println(hm.get(e3));
		
		

	}

}
