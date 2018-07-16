package FileHandling;

import java.io.File;

public class FileDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("D:\\workspace\\Test");
		File files[]=f.listFiles();
		
		for(int i=0;i<files.length;i++){
			System.out.println(files[i].getName());
			System.out.println(files[i].length());
			System.out.println(files[i].isFile());
			System.out.println(files[i].isDirectory());
			System.out.println(files[i].getName());
			System.out.println(files[i].lastModified());
			System.out.println(files[i].canRead());
		}
		
	}

}
