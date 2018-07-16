package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
	

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		while(true) {

			Socket socket = new Socket("localhost", 5000);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream in = new DataInputStream(System.in);

			
			dos.writeUTF(in.readLine());
			String message = dis.readUTF();
			System.out.println("Client says>" + message);		
		}
	}

}
