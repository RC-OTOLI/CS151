package stackMac;

import java.util.ArrayList;

public class Program {
	public ArrayList<Command> commands = new ArrayList<Command>();
	
	public boolean add(Command c) {
		return commands.add(c);
	}
}
