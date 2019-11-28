package presentation;

import business.Simulation;
import framework.Utilities;
import framework.Model;

import java.util.List;
import java.util.ArrayList;

public class World extends Simulation{

	private static final long serialVersionUID = 1L;
	
	public final int SIZE = 500;
	public final int GLOBAL_SPEED = 10;
	private List<Agent> agents = new ArrayList<Agent>();
	
	//Default constructor
	public World() {}
	
	public List<Agent> getAgents() {return agents;}
	
	public boolean addAgent(Agent a) {
		//make sure agent is only associated with one world
		try {
			if(a.world != null) a.world.deleteAgent(a);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		a.setWorld(this);
		agents.add(a);
		
		return true;
	}
	
	public boolean deleteAgent(Agent a) {
		try {
			a.setWorld(null);
			agents.remove(a);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	//Returns a random neighboring agent from within the radius, or null if none are found.
	public Agent findNeighbor(Agent seeker, int radius) {
		List<Agent> neighbors = new ArrayList<Agent>();
		Agent neighbor = null;
		
		//Build a list of neighbors within radius of the agent
		for(Agent a: agents)
			if(Math.sqrt(Math.pow(seeker.xc-a.xc, 2) + Math.pow(seeker.yc-a.yc, 2)) <= radius)
				neighbors.add(a);
		//Remove self from list
		if(neighbors.contains(seeker)) neighbors.remove(seeker);
		
		//Select a random agent from the list of neighbors, or leave as null if list is empty
		if(neighbors.size() != 0) {
			neighbor = neighbors.get(Utilities.nextInt(neighbors.size()));
		}
		
		return neighbor;
	}
	
	@Override
	public void copy(Model m) {
		World world = (World) m;
		this.name = world.name;
		this.clock = world.getClock();
		this.state = world.getState();
		this.setThread(new Thread(this));
		this.agents = world.getAgents();
		super.copy(m);
	}
	
	@Override
	public void update() {for(Agent a: agents) a.update();}
}
