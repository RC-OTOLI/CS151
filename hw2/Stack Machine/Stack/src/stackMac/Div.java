package stackMac;

public class Div implements Command {
	
	public Div() {
		super();
	}
	
	@Override
	public void execute() throws StackTooShortException, DivideByZeroException {
		try {
			//Must have at least two elements on the stack to execute properly
			Double arg1 = StackMachine.stack.pop();
			Double arg2 = StackMachine.stack.pop();
			
			// Since this pushes arg1/arg2, arg2 should not be 0.0
			// Restore the stack before throwing exception so that stack will show the erroneous values and stage.
			if(arg2 == 0.0) {
				StackMachine.stack.push(arg2);
				StackMachine.stack.push(arg1);
				throw new DivideByZeroException("Tried to divide by 0!");
			}
			
			//Cannot throw Syntax error as both arg1 and arg2 are already stack-legal arguments
			StackMachine.stack.push(arg1/arg2);
		}
		catch(EmptyStackException e) {
			throw new StackTooShortException("Div");
		}
	}
}
