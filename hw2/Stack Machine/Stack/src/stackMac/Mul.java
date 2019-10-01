package stackMac;

public class Mul implements Command {

	private Double arg1;
	private Double arg2;
	
	public Mul() {
		super();
	}
	
	@Override
	public void execute() throws StackTooShortException {
		try {
			//Must have at least two elements on the stack to execute properly
			arg1 = StackMachine.stack.pop();
			arg2 = StackMachine.stack.pop();
		}
		catch(EmptyStackException e) {
			throw new StackTooShortException("Mul");
		}
		 
		//Cannot throw Syntax error as both arg1 and arg2 must have already stack-legal arguments
		StackMachine.stack.push(arg1 * arg2);
	}
}
