package MultiThreading;
 class MakeDaemon implements Runnable{
	 
	 Thread t1=new Thread(this);
	 Thread t2=new Thread(this);
	 Thread t3=new Thread(this);
	 
	 public MakeDaemon() {
			t1.setName("Thread_1");
			t2.setName("Thread_2");
			t3.setName("Thread_3");
			t3.setDaemon(true);
			t1.start();
			t2.start();
			t3.start();
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
			
			if(Thread.currentThread().getName().equals("Thread_3")){
				for(;;){
					System.out.println("\tTong");
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {			
						e.printStackTrace();
					}
				}
			}
			
			
		}
 }
public class DaemonTest {

	public static void main(String[] args) {
		new MakeDaemon();
	}

}
