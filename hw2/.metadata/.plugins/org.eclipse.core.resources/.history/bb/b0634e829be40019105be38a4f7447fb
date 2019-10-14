package stackMac;

public class Pop implements Command {

	public Pop() {
		super();
	}
	
	@Override
	public void execute() throws EmptyStackException {
		try {
			System.out.println("Popped: " + StackMachine.stack.pop());
			
		}
		catch(EmptyStackException e) {
			throw e;
		}
	}
}
