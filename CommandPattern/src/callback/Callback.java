/**
 * 
 */
package callback;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * generic callback interface which recieves and returns a generic value
 * 
 * @author Martin Weber
 * @version 06.04.2016
 *
 */
public interface Callback<T> extends Remote {

	/**
	 * a generic value is recieved in this method
	 * 
	 * @param value
	 *            the generic value
	 * @throws RemoteException
	 */
	public void callback(T value) throws RemoteException;
}
