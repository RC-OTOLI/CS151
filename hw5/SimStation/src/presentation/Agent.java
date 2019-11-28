package presentation;

import java.io.Serializable;

import framework.Utilities;

public abstract class Agent implements Serializable{

	private static final long serialVersionUID = 1L;

	protected World world;
	protected int xc;
	protected int yc;
	protected Heading heading;
	
	
	//Restrict all agents to a toroidal space
	public void move(int steps) {
		switch(heading.getString()) {
		case "North":
			yc -= steps;
			if(yc <= 0) yc += world.SIZE; break;
		case "East":
			xc += steps;
			if (xc >= world.SIZE) xc -= world.SIZE;
			break;
		case "South":
			yc += steps;
			if(yc >= world.SIZE) yc -= world.SIZE;
			break;
		case "West":
			xc -= steps;
			if(xc <= world.SIZE) xc += world.SIZE;
			break;
		default: break;
		}
	}
	
	
	public Heading getHeading() {return this.heading;}
	public void turn(Heading heading) {this.heading = heading;}
	//Only initialize values once in the context of a world
	public void setWorld(World w) {
		this.world = w;
		this.heading = Heading.randHeading();
		this.xc = Utilities.nextInt(world.SIZE);
		this.yc = Utilities.nextInt(world.SIZE);
	}
	
	
	abstract public void update();
}
