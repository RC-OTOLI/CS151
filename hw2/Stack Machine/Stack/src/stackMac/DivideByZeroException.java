package stackMac;

public class DivideByZeroException extends StackMachineException {
	public DivideByZeroException(String errorMessage) {
		super("Attampted to divide by zero!");
	}
}
