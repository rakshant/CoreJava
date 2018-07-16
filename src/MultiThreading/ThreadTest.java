package MultiThreading;

class TestingThread implements Runnable{
	
	
	
	Thread t1=new Thread(new Runnable() {
		
		@Override
		public void run() {			
				for(int i=0;i<10;i++){
					System.out.println("Ping");
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {		
						e.printStackTrace();
					}
				}			
		}
	});
	Thread t2=new Thread(new Runnable(){

		@Override
		public void run() {
			for(int i=0;i<10;i++){
					System.out.println("\tPong");
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {			
						e.printStackTrace();
					}
				}

			}		
	});
	
		
	public TestingThread() {
		t1.setName("Thread_1");
		t2.setName("Thread_2");
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("Thread_1")){
			for(int i=0;i<10;i++){
				System.out.println("Ping");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {		
					e.printStackTrace();
				}
			}

		}
		
		if(Thread.currentThread().getName().equals("Thread_2")){
			for(int i=0;i<10;i++){
				System.out.println("\tPong");
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}

		}
		
	}

	
}
public class ThreadTest {

	public static void main(String[] args) {
		
		new TestingThread();

	}

}

