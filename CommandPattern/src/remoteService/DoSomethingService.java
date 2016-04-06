package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.commands.Command;

public interface DoSomethingService extends Remote {

	public void doSomething(Command c) throws RemoteException;
	
}
