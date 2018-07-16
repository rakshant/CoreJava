package Advanced_multithreading;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaterTankAnimation extends Frame{
	int height = 100;
	int y =400;
	
	ExecutorService executor = Executors.newFixedThreadPool(3);
	
	Callable<Integer> callable_1 = new Callable<Integer>() {
		public Integer call() throws Exception {

		int flag=0;
		for (;;) {
			height=height+20;
			y=y-20;			
			repaint();
			try {
				Thread.sleep(300);
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
				height=height-18;
				y=y+18;				
				repaint();
				
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
	}
	};
	Callable<Integer> callable_3 = new Callable<Integer>() {
		public Integer call() throws Exception {

			int flag=0;
			for(;;){

					if(height>=320){
						if(flag==0){
							//t1.suspend();
							flag=1;
						}
					}
			
					if(height<200 && flag==1){					
							//t1.resume();
							flag=0;						
					}
					
					
	
			
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
	}
	};
	
	
	public WaterTankAnimation() {
		setSize(650, 600);
		
		executor.submit(callable_1);
		executor.submit(callable_2);
		executor.submit(callable_3);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
	
	}
	public void paint(Graphics g) {
		//g.setColor(Color.WHITE);
		g.drawRect(200, 100, 300, 400);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(202, y, 296, height);
	}
	

	
	public static void main(String[] args) {
		Frame mf = new WaterTankAnimation();
	}
	


}
