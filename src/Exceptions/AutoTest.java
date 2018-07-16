package Exceptions;

class Auto implements AutoCloseable{

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Closed automatically");
	}
	
}


public class AutoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Auto a=new Auto()){
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
