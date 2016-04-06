/**
 * 
 */
package callback;

import java.rmi.RemoteException;

/**
 * A Class able to print out a generic value
 * 
 * @author Martin Weber
 * @version 06.04.2016
 *
 */
public class PrintCallback<T> implements Callback<T> {

	/**
	 * This Method recieves a generic Value and prints it out
	 * @param the generic value
	 */
	@Override
	public void callback(T value) throws RemoteException {
		System.out.println(value);
		
	}

}
