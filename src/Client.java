abstract class Persistence{
	abstract void persist();
}

class FilePersistence extends Persistence{

	@Override
	void persist() {
		System.out.println("In FilePersistence");		
	}	
}


class DatabasePersistence extends Persistence{

	@Override
	void persist() {
		System.out.println("In DatabasePersistence");
	}	
}

class PersistenceFactory {
	public static Persistence getInstance(){		
		Persistence pf=new DatabasePersistence();
		return pf;		
	}
}

public class Client {

	public static void main(String[] args) {
		Persistence p=PersistenceFactory.getInstance();
		
		if(p instanceof DatabasePersistence)
			p.persist();
		if(p instanceof FilePersistence)
			p.persist();

			
		if(p.getClass() == DatabasePersistence.class)
			System.out.println("Class is DatabasePersistence");
		if(p.getClass() == FilePersistence.class)
			System.out.println("Class is FilePersistence");
		
					
	}

}
