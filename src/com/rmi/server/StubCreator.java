package com.rmi.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StubCreator {
	public static void main(String args[]) throws IOException{
		
		String className=args[0];
	    Runtime.getRuntime().exec("javac -d \"D:\\src\" "+className+".java");
	    
	    FileInputStream fis=new FileInputStream("D:\\src\\"+className+".class");
	    FileOutputStream fos=new FileOutputStream(className+"stub.class");
	    
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
