package Advanced_multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TestingThreadCallable{
	
	ExecutorService executor=Executors.newFixedThreadPool(2);
	Callable<Integer> callable_1=new Callable<Integer>() {

		@Override
		public Integer call() throws Exception {		
			
			for(int i=0;i<10;i++){
				System.out.println("Ping");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}		
			return null;
		}
	};
	
	
	Callable<Integer> callable_2=new Callable<Integer>() {
		
		public Integer call() throws Exception {		
			
			for(int i=0;i<10;i++){
				System.out.println("\tPong");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}		
			return null;
		}
	};
	
	TestingThreadCallable(){
		executor.submit(callable_1);
		executor.submit(callable_2);
	}
}
	
public class ThreadTest {

	public static void main(String[] args) {
		
		new TestingThreadCallable();

	}

}

