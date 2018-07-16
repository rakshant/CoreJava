package InnerClasses;
import java.util.HashMap;

class Cache{
	
	HashMap<String, CacheDetails> hm = new HashMap<String, CacheDetails>();
	
	public String get(String key) {
		
		CacheDetails cd=this.hm.get(key);		
		return cd.getValue();		
	}

	public void put(String key,String value) {
		this.hm.put(key,new CacheDetails(value));
	}

	private static Cache instance=null;
	
	private Cache()
	{	}	

	public static  Cache getcache()	{
		
	    if(instance == null)
	    {
	         instance = new Cache();
	     }
		return instance;	     
	}


	class CacheDetails{
		
		String value;
		long timestamp;			
		
		public CacheDetails(String value) {
			super();			
			this.value = value;
			timestamp=System.currentTimeMillis();
		}	
		 public CacheDetails() {
			// TODO Auto-generated constructor stub
		}
		public String toString(){			 
			return "Value-"+value+" and timestamp-"+timestamp;
		 }
		public String getValue() {
			return value;
		}
		 
		 
	}
}


public class CachedTest {

	public static void main(String[] args) {
		Cache c=Cache.getcache();
		
		c.put("R1","Rakshant");
		System.out.println(c.get("R1"));

	}

}
