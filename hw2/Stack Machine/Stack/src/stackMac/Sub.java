package stackMac;

public class Sub implements Command {

	private Double arg1;
	private Double arg2;
	
	public Sub() {
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
			throw new StackTooShortException("Sub");
		}
		 
		//Cannot throw Syntax error as both arg1 and arg2 must have already stack-legal arguments
		StackMachine.stack.push(arg1 - arg2);
	}
}
