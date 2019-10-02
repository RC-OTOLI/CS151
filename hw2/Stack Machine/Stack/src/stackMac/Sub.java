package stackMac;

public class Sub implements Command {

	public Sub() {
		super();
	}
	
	@Override
	public void execute() throws StackTooShortException {
		try {
			//Must have at least two elements on the stack to execute properly
			Double arg1 = StackMachine.stack.pop();
			Double arg2 = StackMachine.stack.pop();
			
			//Cannot throw Syntax error as both arg1 and arg2 are already stack-legal arguments
			StackMachine.stack.push(arg1 - arg2);
		}
		catch(EmptyStackException e) {
			throw new StackTooShortException("Sub");
		}
	}
}
