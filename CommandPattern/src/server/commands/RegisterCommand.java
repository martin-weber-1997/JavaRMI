package server.commands;

import java.io.Serializable;

public class RegisterCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;

	@Override
	public void execute() {
		System.out.println("RegisterCommand called!");
	}
}
