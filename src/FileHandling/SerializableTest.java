package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Account implements Serializable{
	
	private static final long serialVersionUID = 100;
	int id;
	String name;
	transient double balance;
	public Account(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return id+" -"+name+" -"+balance;
	}
}
public class SerializableTest {

	public static void main(String[] args) throws Exception {
		
		Account a1=new Account(1,"Alex", 200.25);
		File file =new File("s.dat");
		
		//Serialize
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(a1);
		oos.close();
		fos.close();
		
		//Deserialize
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Account a2=(Account) ois.readObject();
		ois.close();
		fis.close();
		
		System.out.println("Original-"+a1);
		System.out.println("Deserialized-"+a2);

	}

}
