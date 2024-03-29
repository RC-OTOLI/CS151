package stackMac;

public class Mul implements Command {
	
	public Mul() {
		super();
	}
	
	@Override
	public void execute() throws StackTooShortException {
		try {
			//Must have at least two elements on the stack to execute properly
			Double arg1 = StackMachine.stack.pop();
			Double arg2 = StackMachine.stack.pop();
			
			//Cannot throw Syntax error as both arg1 and arg2 must already be stack-legal arguments
			StackMachine.stack.push(arg1 * arg2);
		}
		catch(EmptyStackException e) {
			throw new StackTooShortException("Mul");
		}
	}
}
