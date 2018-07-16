package MultiThreading;

import java.awt.*;
import java.awt.event.*;

public class WaterTankAnimation extends Frame implements Runnable{
	int height = 100;
	int y =400;
	
	Thread t1 = new Thread(this);
	Thread t2 = new Thread(this);
	Thread t3 = new Thread(this);
		
	public WaterTankAnimation() {
		setSize(650, 600);
		
		t1.setName("Thread_1");
		t2.setName("Thread_2");
		t3.setName("Thread_3");
		t3.setDaemon(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
		t1.start();
		t2.start();
		t3.start();
	}
	public void paint(Graphics g) {
		//g.setColor(Color.WHITE);
		g.drawRect(200, 100, 300, 400);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(202, y, 296, height);
	}
	
	
	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("Thread_1")) {

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
		if (Thread.currentThread().getName().equals("Thread_2")) {

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
		if (Thread.currentThread().getName().equals("Thread_3")) {
			
			int flag=0;
			for(;;){

					if(height>=320){
						if(flag==0){
							t1.suspend();
							flag=1;
						}
					}
			
					if(height<200 && flag==1){					
							t1.resume();
							flag=0;						
					}
					
					
	
			
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Frame mf = new WaterTankAnimation();
	}
	


}
