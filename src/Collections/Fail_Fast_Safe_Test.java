package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class Test implements Runnable{

	Thread t1=new Thread(this);
	Thread t2=new Thread(this);
	
//	ArrayList<String> al=new ArrayList<String>();
	
	CopyOnWriteArrayList<String> al=new CopyOnWriteArrayList<String>();
	
	Test(){
		al.add("Samsung");
		al.add("HTC");
		t1.setName("Thread_1");
		t2.setName("Thread_2");
		t1.start();
		t2.start();
	}

	
	@Override
	public void run() {
		
		if(Thread.currentThread().getName().equals("Thread_1")){
			Iterator<String> itr_1=al.iterator();
			while(itr_1.hasNext()){
				System.out.println(itr_1.next());				
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(Thread.currentThread().getName().equals("Thread_2")){
				al.add("Apple");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class Fail_Fast_Safe_Test {
	
	public static void main(String[] args) {
		new Test();

	}
}
	

