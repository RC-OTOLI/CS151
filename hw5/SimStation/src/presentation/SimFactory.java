package presentation;

import framework.AppFactory;
import framework.AppPanel;
import framework.Command;
import framework.Model;

import java.awt.event.ActionListener;

public class SimFactory implements AppFactory{

	String type;
	int numAgents;
	
	//Default to a "birds" simulation
	@Override
	public Model makeModel() {
		return makeModel("Bird", 100);
	}
	
	//Handle different agent types
	public Model makeModel(String t, int na) {
		World world = new World();
		type = t;
		numAgents = na;
		try {
			//populate world with appropriate agents
			for(int i = 0; i < numAgents; i++) {
				switch(type) {
				case "Bird":
					world.addAgent(new Bird());
					break;
				case "Drunk":
					world.addAgent(new Drunk());
					break;
				default:
					throw new Exception("No such Agent type!");
				}
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return world;
	}

	@Override 
	public AppPanel makePanel(Model model, ActionListener listener) {
		return new SimPanel(model, listener);
	}

	@Override
	public String[] getEditCommands() {
		String[] editCom = {"Start", "Suspend", "Resume", "Stop"};
		return editCom;
	}

	@Override
	public Command makeEditCommand(Model model, String type) {
		if(type == "Start") {
			return new SimStart(model);
		}else if(type == "Suspend") {
			return new SimSuspend(model);
		}else if(type == "Resume") {
			return new SimResume(model);
		}else if(type == "Stop") {
			return new SimStop(model);
		}
		return null;
	}

	@Override
	public String getTitle() {
		return "SimStation; Drunks and Birds";
	}

	@Override
	public String getHelp() {
		return "Simulate random walks or flocking behavior";
	}

	@Override
	public String about() {
		return "SimStation version 1.0";
	}

}