package server;

import java.rmi.RemoteException;

import remoteService.DoSomethingService;
import server.commands.Command;

public class ServerService implements DoSomethingService {

	@Override
	public void doSomething(Command c) throws RemoteException {
		c.execute();

	}

}
