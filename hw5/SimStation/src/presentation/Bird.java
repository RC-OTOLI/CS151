package presentation;

import framework.Utilities;

public class Bird extends Agent{

	private static final long serialVersionUID = 1L;
	
	private int speed;
	
	public Bird() {
		super();
	}
	
	//Only initialize values when in the context of a world
	public void setWorld(World w) {
		super.setWorld(w);
		speed = Utilities.randInt(1, w.GLOBAL_SPEED);
	}

	public int getSpeed() {return this.speed;}
	public void setSpeed(int speed) {this.speed = Math.min(speed, world.GLOBAL_SPEED);}
	
	
	@Override
	public void update() {
		Bird b = (Bird)world.findNeighbor(this, 30);
		if(b != null) {
			this.turn(b.getHeading());
			this.setSpeed(b.getSpeed());
		}
		move(speed);

//		Enable for non-uniform speed		
//		this.speed = Utilities.randInt(
//				Math.max(speed - 1, 1), 
//				Math.min(speed + 2, world.GLOBAL_SPEED));
	}
}
