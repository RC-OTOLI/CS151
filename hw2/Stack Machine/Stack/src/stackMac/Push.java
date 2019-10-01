package stackMac;

public class Push implements Command {
	
	Double arg;
	
	public Push(Double arg) {
		super();
		this.arg = arg;
	}
	
	@Override
	public void execute(){
		StackMachine.stack.push(arg);
	}
}
