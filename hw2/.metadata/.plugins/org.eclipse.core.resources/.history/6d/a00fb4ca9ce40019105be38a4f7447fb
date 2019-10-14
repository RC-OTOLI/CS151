package stackMac;

public class StackMachine {
	
	public static GenericStack<Double> stack = new GenericStack<Double>();
	
	public static void execute(Program p) {
		//Make sure the stack is clear before running a new program
		stack.clear();
		
		//Execute the list of commands in p sequentially, FIFO
		//Exceptions caught and handled at this level
		//All exception handlers are placeholders for now
		for(Command c: p.commands) {
			try {
				c.execute();
			}
			//Thrown by Pop 
			catch(EmptyStackException s) {
				System.out.println(s.getMessage());
			}
			//Thrown by Add, Sub, Mul, Div
			catch(StackTooShortException s) {
				System.out.println(s.getMessage());
			}
			//Thrown by Div
			catch(DivideByZeroException s) {
				System.out.println(s.getMessage());
			}
			//TODO clear up: Thrown by execute?
			catch(SyntaxError s) {
				System.out.println(s.getMessage());
			}
			//Thrown if any other command-based error
			catch(StackMachineException s) {
				System.out.println(s.getMessage());
			}
		}
		
		System.out.println(stack);
	}
	
}
