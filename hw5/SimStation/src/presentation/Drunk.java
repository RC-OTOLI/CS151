package presentation;

import framework.Utilities;

public class Drunk extends Agent{

	private static final long serialVersionUID = 1L;

	public Drunk() {
		super();
	}
	
	@Override
	public void update() {
		turn(Heading.randHeading());
		move(Utilities.randInt(1, world.GLOBAL_SPEED));
	}
}
