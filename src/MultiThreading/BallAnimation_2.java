package MultiThreading;
import java.awt.*;
import java.awt.event.*;

import javax.naming.NoInitialContextException;

public class BallAnimation_2 extends Frame implements Runnable {

	int x, y, z = 0;

	Thread t1 = new Thread(this);
	Thread t2 = new Thread(this);
	Thread t3 = new Thread(this);

	boolean flag_1=false,flag_2=false;
	@Override
	 public void run() {

		if (Thread.currentThread().getName().equals("Thread_1")) {

			int flag=0;
			for (;;) {
				
				if(flag==0){
					x=x-5;
					
					
						if(x<20){
							flag=1;
							check();
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
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
			
		if (Thread.currentThread().getName().equals("Thread_2")) {

			int flag=0;
			for (;;) {
				if(flag==0){
					y = y - 10;		
					
					
						if(y<20){
							flag=1;	
							check();
							
					
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
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (Thread.currentThread().getName().equals("Thread_3")) {

			int flag =0;
			for (;;) {
				if(flag==0){
					z = z - 15;
					
					if(z<20){						
						flag=1;
						check();					
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
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				
			}
			
	}
	}
	
	synchronized public void check(){
				if(!flag_1){
					flag_1=true;
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(!flag_2 && flag_1){
					flag_2=true;
					try {
						
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				
				if(flag_1 && flag_2){
					flag_1=false;
					flag_2=false;
					try {								
						notifyAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
	}

	public BallAnimation_2() {
		t1.setName("Thread_1");
		t2.setName("Thread_2");
		t3.setName("Thread_3");
		y = x = z = 500;
		setBackground(Color.CYAN);
		setSize(650, 600);
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
