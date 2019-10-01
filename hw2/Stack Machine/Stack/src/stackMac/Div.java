package stackMac;

public class Div implements Command {

	private Double arg1;
	private Double arg2;
	
	public Div() {
		super();
	}
	
	@Override
	public void execute() throws StackTooShortException, DivideByZeroException {
		try {
			//Must have at least two elements on the stack to execute properly
			arg1 = StackMachine.stack.pop();
			arg2 = StackMachine.stack.pop();
		}
		catch(EmptyStackException e) {
			throw new StackTooShortException("Div");
		}
		
		// Since this pushes arg1/arg2, arg2 should not be 0.0
		// Restore the stack before throwing exception so that stack will show the erroneous values and stage.
		if(arg2 == 0.0) {
			StackMachine.stack.push(arg2);
			StackMachine.stack.push(arg1);
			throw new DivideByZeroException("Tried to divide by 0!");
		}
		
		//Cannot throw Syntax error as both arg1 and arg2 must have already stack-legal arguments
		StackMachine.stack.push(arg1/arg2);
	}
}
