package com.rmi.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.rmi.Remote;

public class Naming {

	public static void rebind(String referenceName, Remote remoteObject) throws Exception {

		Socket socket = new Socket("localhost", 5000);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject("getRegistry");
		oos.writeObject(referenceName);
		oos.writeObject(remoteObject);
		oos.flush();
		oos.close();
		socket.close();
	}

	public static Remote lookup(String objectName) throws Exception {

		Socket socket = new Socket("localhost", 5000);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

		oos.writeObject("createRegistry");
		oos.writeObject(objectName);
		Remote remoteObject = (Remote) ois.readObject();

		oos.flush();
		oos.close();
		ois.close();
		socket.close();

		return remoteObject;
	}

}
