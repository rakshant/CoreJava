package FileHandling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryTest {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("account.dat");
		DataOutputStream dos=new DataOutputStream(fos);
		
		
		dos.writeInt(1);
		dos.writeUTF("Ram");
		dos.writeDouble(1000.12);
		
		FileInputStream fis=new FileInputStream("account.dat");
		DataInputStream dis=new DataInputStream(fis);
		System.out.println(dis.readInt());
		System.out.println(dis.readUTF());
		System.out.println(dis.readDouble());

	}
	


}
