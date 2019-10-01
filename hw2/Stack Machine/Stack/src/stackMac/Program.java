package stackMac;

import java.util.ArrayList;

public class Program {
	public ArrayList<Command> commands = new ArrayList<Command>();
	
	public boolean add(Command c) throws SyntaxError{
		try {
			commands.add(c);
		}
		catch(Exception s) {
			throw new SyntaxError("Command not recognized!");
		}
		
		return commands.add(c);
	}
}
