package presentation;

import business.SimState;
import business.Simulation;
import framework.Command;
import framework.Model;

public class SimSuspend extends Command {

	public SimSuspend(Model m) {
		super(m);
	}

	@Override
	public void execute() throws Exception {
		Simulation sim = (Simulation)model;
		if(sim.getState() == SimState.READY) throw new Exception("Simulation has not started yet!");
		else if(sim.getState() == SimState.STOPPED) throw new Exception("Cannot suspend a stopped simulation!");
		else sim.suspend();
	}
}
