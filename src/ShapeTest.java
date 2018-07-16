abstract class Shape{
	public abstract String draw();
}



class Rectangle extends Shape{

	@Override
	public String draw() {
		// TODO Auto-generated method stub
		return "Rectangle drawn";
	}
	
}
class Cube extends Shape{

	@Override
	public String draw() {
		// TODO Auto-generated method stub
		return "Cube drawn";
	}
	
}

class Line extends Shape{

	@Override
	public String draw() {
		// TODO Auto-generated method stub
		return "Line drawn";
	}
	
}


public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Rectangle().draw());
		System.out.println(new Line().draw());
		System.out.println(new Cube().draw());

	}

}
