package FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReadWrite {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("a.txt");
		FileOutputStream fos=new FileOutputStream("b.txt");
		
	
		int i=0;
		
		do{
			i=fis.read();
			if(i!=-1){
				fos.write(i);
			}
		}while(i!=-1);
		
		fis.close();
		fos.close();
		
	}

}
