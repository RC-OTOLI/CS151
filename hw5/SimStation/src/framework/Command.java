package framework;

public abstract class Command {
	
	protected Model model;
	
	abstract public void execute() throws Exception;
	
	public Command(Model m) {
		model = m;
	}
	
}
