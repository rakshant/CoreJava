package MultiThreading;

class TestingThread_2 extends Thread{	
		
	public TestingThread_2(String name) {
		this.setName(name);
		this.start();

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

	
}public class ThreadTest_2 {

	public static void main(String[] args) {
		new TestingThread_2("Thread_1");
		new TestingThread_2("Thread_2");
		

	}

}
