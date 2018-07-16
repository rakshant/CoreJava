
class Singleton{
	private static Singleton instance=null;
	
	private Singleton()
	{
		// TODO Auto-generated constructor stub
	}	

	public static  Singleton getSingleton()
	{
		
	    if(instance == null)
	    {
	         instance = new Singleton();
	     }
		return instance;
	     
	}	
	
}


public class SingeltonTest {

	public static void main(String[] args) {
		
		Singleton s1=Singleton.getSingleton();
		Singleton s2=Singleton.getSingleton();
		System.out.println(s1);
		System.out.println(s2);		

	}

}
