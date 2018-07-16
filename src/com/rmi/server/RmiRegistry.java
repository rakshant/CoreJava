package com.rmi.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.rmi.Remote;

public class RmiRegistry {

	static HashMap<String, Remote> registry = new HashMap<String, Remote>();

	public void createRegistry(String referenceName, Remote remoteReference) {
		registry.put(referenceName, remoteReference);
	}

	public Remote getRegistry(String name) {
		return registry.get(name);
	}

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		String referenceName = "";
		ServerSocket serverSocket = null;

		System.out.println("Regisry started");
		while (true) {
			@SuppressWarnings("null")
			Socket socket = serverSocket.accept();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			String method = (String) ois.readObject();

			switch (method) {

			case "getRegistry":
				referenceName = (String) ois.readObject();
				Object obj = RmiRegistry.registry.get(referenceName);
				oos.writeObject(obj);
				break;

			case "createRegistry":
				referenceName = (String) ois.readObject();
				Remote remoteReference = (Remote) ois.readObject();
				RmiRegistry.registry.put(referenceName, remoteReference);
				break;
			}
		}
	}
}
