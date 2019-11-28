package presentation;

import business.SimState;
import business.Simulation;
import framework.Command;
import framework.Model;

public class SimStop extends Command {

	public SimStop(Model m) {
		super(m);
	}

	@Override
	public void execute() throws Exception{
		Simulation sim = (Simulation)model;
		if(sim.getState() == SimState.READY) throw new Exception("Cannot stop a simulation that has not started yet!");
		else sim.stop();
	}
}
