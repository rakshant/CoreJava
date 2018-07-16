package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {

	public static void main(String[] args) throws Exception {
		File file =new File("random.dat");
		RandomAccessFile raf1=new RandomAccessFile(file, "rw");		
		RandomAccessTest.appendFile(file);		
		raf1.close();
				
		RandomAccessFile raf2=new RandomAccessFile(file, "rw");
		RandomAccessTest.readFile(raf2,10);

		RandomAccessTest.update(raf2,20,25000.25);		
		RandomAccessTest.readFile(raf2,20);
		
		RandomAccessTest.accountCheck(raf2);
		
		RandomAccessTest.readFile(raf2,20);
		raf2.close();
						
	}

	public static void readFile(RandomAccessFile raf,int id) throws IOException{
		raf.seek(0);	
	
		do{
			int uid=raf.readInt();
			if(uid==id){
				System.out.println(uid);
				System.out.println(raf.readUTF());
				System.out.println(raf.readDouble());	
			}
			else{
				raf.readUTF();
				raf.readDouble();				
			}		
		}while(raf.getFilePointer()<raf.length());
}
	
	public static void writeFile(RandomAccessFile raf) throws IOException{
		
		raf.writeInt(25);
		raf.writeUTF("Tom");
		raf.writeDouble(20000.25);
		
		raf.writeInt(20);
		raf.writeUTF("Alex");
		raf.writeDouble(21000.25);		
	}
	
	public static void appendFile(File file) throws IOException{
		RandomAccessFile raf=new RandomAccessFile(file,"rw");
		raf.seek(file.length());
		raf.writeInt(10);
		raf.writeUTF("Chang");
		raf.writeDouble(30000.25);
		
	}
	
	
	public static void update(RandomAccessFile raf, int id,double d) throws Exception{
		raf.seek(0);	
		
		do{
			int uid=raf.readInt();
			if(uid==id){				
				raf.readUTF();
				raf.writeDouble(d);
			}
			else{
				raf.readUTF();
				raf.readDouble();				
			}		
		}while(raf.getFilePointer()<raf.length());
		raf.seek(0);	
		
	}
	
	public static void delete(RandomAccessFile raf, int id) throws IOException {
		raf.seek(0);	
		
		do{
			int uid=raf.readInt();
			if(uid==id){
				
				raf.writeInt(0);	
				raf.writeUTF("");
				raf.writeDouble(0.0);
				System.out.println("record deleted");
				
			}
			else{
				raf.readUTF();
				raf.readDouble();				
			}		
		}while(raf.getFilePointer()<raf.length());
	}
	
	
	public static void accountCheck(RandomAccessFile raf) throws IOException{
		
		raf.seek(0);	
		
		do{
			int id=raf.readInt();
			String name=raf.readUTF();
			double bal=raf.readDouble();
			if(bal>10000){
				System.out.println("Account with value more than 10000-"+id+"  "+name+"  "+bal);
				
			}
				
		}while(raf.getFilePointer()<raf.length());
				
	}
}
