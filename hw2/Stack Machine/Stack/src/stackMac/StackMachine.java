package stackMac;

public class StackMachine {
	
	public static GenericStack<Double> stack = new GenericStack<Double>();
	
	public static void execute(Program p) {
		
		//Make sure the stack is clear before running a new program
		stack.clear();
		
		//Exceptions caught and handled at this level
		//All exception handlers are placeholders for now
		try {
			p.execute();
		}
		//Thrown by Pop 
		catch(EmptyStackException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//Thrown by Add, Sub, Mul, Div
		catch(StackTooShortException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//Thrown by Div
		catch(DivideByZeroException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//Thrown by parser (future version)
		catch(SyntaxError e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//Thrown if any other command-based error
		catch(StackMachineException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//For all other exceptions
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		System.out.println(stack);
	}
	
}
