package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;


public class Server implements Runnable{
	

	public Server() {
		
	}
	
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(5000);
		System.out.println("TCP_IP server started");

		ArrayList<Socket> connections = new ArrayList<Socket>();

		while (true) {
			Socket socket = serverSocket.accept();
			connections.add(socket);
			
			Runnable run=new Server();
			Thread t=new Thread(run);
			t.start();

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			String clientMessage = dis.readUTF();
			Iterator<Socket> itr = connections.iterator();
                                                                                                                                                          
			while (itr.hasNext()) {
				dos.writeUTF(clientMessage);
			}			
		}
	}

	@Override
	public void run() {
		
	}
}
