package stackMac;

public class StackMachine {
	//This stack machine will only work for values that can be cast to doubles
	public static GenericStack<Double> stack;
	
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
			//Thrown by Add, Sub, Mul, Div, Pop 
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
			//Thrown by push (in this context)
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
