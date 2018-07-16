interface Printable{
	void printing();
}

class Employees implements Printable{

	@Override
	public void printing() {
		// TODO Auto-generated method stub
		System.out.println("Emp printed");
	}
	
}

class Circles implements Printable{

	@Override
	public void printing() {
		// TODO Auto-generated method stub
		System.out.println("Circle printed");
	}
	
}

public class PrintableTest {
	
	public static void printAll(Printable[] p1){
		for(int i=0;i<p1.length;i++){
			p1[i].printing();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printable p[]=new Printable[4];
		p[0]=new Circles();
		p[1]=new Employees();
		p[2]=new Circles();
		p[3]=new Employees();
		printAll(p);
	}

}
