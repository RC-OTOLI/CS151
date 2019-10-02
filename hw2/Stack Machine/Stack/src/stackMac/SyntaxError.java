package stackMac;

public class SyntaxError extends StackMachineException {
	public SyntaxError(String errorMessage) {
		super("Syntax error");
	}
}