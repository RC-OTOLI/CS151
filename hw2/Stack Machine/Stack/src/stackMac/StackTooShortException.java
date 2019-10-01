package stackMac;

public class StackTooShortException extends StackMachineException {
	public StackTooShortException(String errorMessage) {
		super("Too few elements in the stack to complete the operation: " + errorMessage);
	}
}
