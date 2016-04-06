package client;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import calculation.Calculation;
import calculation.PICalc;
import callback.Callback;
import callback.PrintCallback;
import remoteService.DoSomethingService;
import server.commands.CalculationCommand;
import server.commands.Command;
import server.commands.RegisterCommand;
import server.commands.LoginCommand;
/**
 * Client class invoking 2 given Example Methods and a Method to compute Pi
 * To return the Value of pi to the Client a Callback is used
 * 
 * @author Martin Weber, Michael Borko
 * @version 06.04.2016
 *
 */
public class Client {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			
			Registry registry = LocateRegistry.getRegistry(1234);//Tries to locate the registry on port 1234
			DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");//looks up service in the registry
			System.out.println("Service found");

			//two example commands
			Command rc = new RegisterCommand();
			Command lc = new LoginCommand();

			Calculation pi = new PICalc(Integer.parseInt(args[0]));
			PrintCallback<BigDecimal> pcb=new PrintCallback<BigDecimal>();//Callback object 
			Callback<BigDecimal> cbstub = (Callback<BigDecimal>) UnicastRemoteObject.exportObject(pcb, 0);//exported stub callback object
			Command pc = new CalculationCommand(pi,cbstub);//Command for calculation Pi
			
			//executing the commands
			uRemoteObject.doSomething(rc);
			uRemoteObject.doSomething(lc);
			uRemoteObject.doSomething(pc);
			
			
			UnicastRemoteObject.unexportObject(pcb, true);//removes callback so it can no longer recieve incoming RMI calls
			System.out.println("Removed Callback");
		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
