package framework;

public abstract class CommandProcessor {
	
	public static void execute(Command cmmd) throws Exception { cmmd.execute(); }
	
}
