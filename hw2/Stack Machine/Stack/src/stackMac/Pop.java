package stackMac;

public class Pop implements Command {

	public Pop() {
		super();
	}
	
	@Override
	public void execute() throws EmptyStackException {
		try {
			StackMachine.stack.pop();
		}
		catch(EmptyStackException s) {
			throw s;
		}
	}

}
