package stackMac;

public class Pop implements Command {

	public Pop() {
		super();
	}
	
	@Override
	public void execute() throws EmptyStackException {
			System.out.println(StackMachine.stack.pop() + " was popped!");
	}
}
