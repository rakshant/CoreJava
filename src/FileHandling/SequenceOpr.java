package FileHandling;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceOpr {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis1=new FileInputStream("D:\\workspace\\Test\\a.txt");
		FileInputStream fis2=new FileInputStream("D:\\workspace\\Test\\b.txt");
		FileInputStream fis3=new FileInputStream("D:\\workspace\\Test\\c.txt");
		 
		Vector<InputStream> v=new Vector<InputStream>();
		v.add(fis1);
		v.add(fis2);
		v.add(fis3);
		Enumeration<InputStream> en=v.elements();
		SequenceInputStream sis=new SequenceInputStream(en);
		
		int i=0;
		
		//StringBuilder sb=new StringBuilder();
		
		do{
			i=sis.read();			
			if(i!=-1){
				//sb.append((char)i);
				System.out.print((char)i);
			}
		}while(i!=-1);
		
		
		//System.out.println("File Contents-\n"+sb);
		sis.close();
		fis1.close();
		fis2.close();
		fis3.close();
	}

}
