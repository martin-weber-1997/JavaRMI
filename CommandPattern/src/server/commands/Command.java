package server.commands;

import java.io.Serializable;

public interface Command extends Serializable {

	public void execute();
}
