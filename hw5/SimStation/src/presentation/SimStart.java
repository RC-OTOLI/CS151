package presentation;

import business.SimState;
import business.Simulation;
import framework.Command;
import framework.Model;

public class SimStart extends Command {

	public SimStart(Model m) {
		super(m);
	}

	@Override
	public void execute() throws Exception{
		Simulation sim = (Simulation)model;
		if(sim.getState() == SimState.RUNNING) throw new Exception("Simulation already in progress!");
		else if(sim.getState() != SimState.READY) throw new Exception("Cannot start a stopped/suspended simulation!");
		else sim.start();
	}
}
