package com.rmi;


public class RemoteException extends Exception {
	private static final long serialVersionUID = 1L;
	
	String message = "Remote Invocation Exception";

	public RemoteException() {
		this.message = "";
	}

	public RemoteException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

	
}