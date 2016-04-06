package server.commands;

import java.io.Serializable;
import calculation.Calculation;
/**
 * 
 * @author Martin Weber, Michael Borko
 * @version 06.04.2016
 *
 */
public class CalculationCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;
	private Calculation calc;

	public CalculationCommand(Calculation calc) {
		this.calc = calc;
	}

	@Override
	public void execute() {
		calc.calculate();
		System.out.println("CalculationCommand called! " +calc.getResult().toString());
	}
}
