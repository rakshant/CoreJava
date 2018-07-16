package FileHandling;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Accounts implements Externalizable{
	
	private static final long serialVersionUID = 100;
	int id;
	String name;
	transient double balance;
	public Accounts(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public String toString(){
		return id+" -"+name+" -"+balance;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		id=in.readInt();
		name=in.readUTF();
		balance=in.readDouble();
		System.out.println("Deserialize-"+id+" -"+name+" -"+balance);
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeUTF(name);
		out.writeDouble(balance);
		
	}
}

public class ExternalTest {

	public static void main(String[] args) throws Exception {
		Accounts a1=new Accounts(1,"Alex", 200.25);
		File file =new File("e.dat");
		
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		a1.writeExternal(oos);
		oos.close();
		fos.close();
		
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		a1.readExternal(ois);
		ois.close();
		fis.close();

	}

}
