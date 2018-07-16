package Advanced_multithreading;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class BallAnimation_2 extends Frame  {

	int x, y, z = 0;
	boolean flag_1=false,flag_2=false;
	AtomicBoolean reached=new AtomicBoolean(false);
	
ExecutorService executor = Executors.newFixedThreadPool(3);
	
	Callable<Integer> callable_1 = new Callable<Integer>() {
		
		@Override
		public Integer call() throws Exception {
			
			int flag=0;
			for (;;) {
				
				if(flag==0){
					x=x-5;
					
					
						if(x<20){
							flag=1;
							
							lock.lock();
							reached=new AtomicBoolean(true);
							lock.unlock();
							
						}
				}
	
				if(flag==1){
					
					
					x=x+5;
					if(x>520){
						flag=0;
						check();
					}
						
				}
				

				repaint();
				
				try {
					TimeUnit.MILLISECONDS.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	};
	
	Callable<Integer> callable_2 = new Callable<Integer>() {

		public Integer call() throws Exception {		
			int flag=0;
			for (;;) {
				if(flag==0){
					y = y - 10;		
					
					
						if(y<20){
							flag=1;	
							lock.lock();
							while(reached.get()){}
							lock.unlock();
							
					
					}
				}
				if(flag==1){
					y=y+10;
					if(y>520){
						flag=0;
						check();
					}
						
				}
				
				
				repaint();
				try {
					TimeUnit.MILLISECONDS.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	Callable<Integer> callable_3 = new Callable<Integer>() {

		public Integer call() throws Exception {
		
			int flag =0;
			for (;;) {
				if(flag==0){
					z = z - 15;
					
					if(z<20){						
						flag=1;
						lock.lock();
						while(reached.get()){}
						lock.unlock();					
					}
				}
				
				if(flag==1){
					z=z+15;
					if(z>520){
						flag=0;
						check();	
					}
						
				}				
			
				repaint();
						try {
							TimeUnit.MILLISECONDS.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				
			}
			
	}
	};
	

	ReentrantLock lock = new ReentrantLock();
	
	public void check() throws InterruptedException{
		boolean set_1 = false,set_2 = false,status=false;		

		
				if(!flag_1){									
					flag_1=true;	
					
				}
				
				if(!flag_2 && flag_1){															
						flag_2=true;										
				}	
				
				if(flag_1 && flag_2){						
						flag_1=false;
						flag_2=false;					
				}	
				
		
	}

	public BallAnimation_2() {

		y = x = z = 500;		
		executor.submit(callable_1);
		executor.submit(callable_2);
		executor.submit(callable_3);
		setBackground(Color.CYAN);
		setSize(650, 600);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);

	}

	public void paint(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillOval(100, x, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(300, y, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(500, z, 50, 50);
	}

	public static void main(String[] args) {
		Frame mf = new BallAnimation_2();
	}

}
