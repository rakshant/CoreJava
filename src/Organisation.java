class Employee {

	private int id;
	private int salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, int salary) {
		this.id = id;
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

}

class Manager extends Employee {
	private int incentive;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, int salary, int incentive) {
		super(id, salary);
		this.incentive = incentive;

	}

	public int getSalary() {
		return super.getSalary() + incentive;
	}

}

class Labour extends Employee {
	private int overtime;

	public Labour() {
		// TODO Auto-generated constructor stub
	}

	public Labour(int id, int salary, int overtime) {
		super(id, salary);
		this.overtime = overtime;
	}

	public int getSalary() {
		return super.getSalary() + overtime;
	}

}

public class Organisation {

	
	public static void getTotalSalary(Employee e[]) {
		int totalSalary=0;
		for(int i=0;i<e.length;i++){
			totalSalary=e[i].getSalary();
		}
		
		System.out.println("Total salary is-"+totalSalary);
		

	}

	public static void main(String[] args) {
		
		Employee e[]=new Employee[4];
		e[0]=new Manager(1,5000,1000);
		e[1]=new Labour(2,1000,200);
		e[2]=new Manager(3,5000,500);
		e[3]=new Labour(4,1000,300);
		Organisation.getTotalSalary(e);
		
		

		

	}

}
