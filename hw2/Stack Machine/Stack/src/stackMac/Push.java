package stackMac;

public class Push<T> implements Command {

	Double arg;
	
	public Push(T arg) {
		super();
		this.arg = (Double) arg;
	}
	
	@Override
	public void execute(){
		StackMachine.stack.push(arg);
	}

}
