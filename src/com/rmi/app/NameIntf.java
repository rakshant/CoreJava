package com.rmi.app;

import com.rmi.Remote;
import com.rmi.RemoteException;

public interface NameIntf extends Remote {
	public String getCapName(String name) throws RemoteException;
}
