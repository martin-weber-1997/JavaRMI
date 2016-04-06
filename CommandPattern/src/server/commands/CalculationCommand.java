package server.commands;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import calculation.Calculation;
import callback.Callback;
/**
 * 
 * @author Martin Weber, Michael Borko
 * @version 06.04.2016
 *
 */
public class CalculationCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;
	private Calculation calc;
	private Callback<BigDecimal> cb;

	public CalculationCommand(Calculation calc,Callback<BigDecimal> cb) {
		this.calc = calc;
		this.cb=cb;
	}

	@Override
	public void execute() {
		calc.calculate();
		try{
			cb.callback(calc.getResult());
			System.out.println("Calculation Command called!");
		}
		catch(RemoteException re){
			System.err.println("Exception while recieving result");
		}
	}
}
