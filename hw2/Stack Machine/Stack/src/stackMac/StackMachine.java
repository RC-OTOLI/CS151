package stackMac;

public class StackMachine {
	public static GenericStack<Double> stack;
	
	public static void execute(Program p) {
		for(Command c: p.commands) {
			try {
				c.execute();
			}
			catch(StackMachineException s) {
				System.out.println(s.getMessage());
			}
		}
	}
	
}
