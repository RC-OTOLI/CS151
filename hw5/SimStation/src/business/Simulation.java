package business;
import framework.*;


public abstract class Simulation extends Model implements Runnable {

	private static final long serialVersionUID = 1L;

	protected String name;		//WHAT IS THIS FIELD USED FOR? Never invoked/called
	protected long clock = 0l;
	protected SimState state = SimState.READY;
	private transient Thread thread;
	
	
	public Simulation() {
		super("Simulation");	//Name of this model
		setThread(new Thread(this));
	}
	
	
	//Thread mutators
	public void start() {
		thread.start();
		state = SimState.RUNNING;
	}
	
	public void stop() {
		state = SimState.STOPPED;
	}
	
	public void suspend() {
		state = SimState.SUSPENDED;
	}
	
	public synchronized void resume() {
		state = SimState.RUNNING;
		notify();
	}
	//End Thread mutators
	
	
	public long getClock() {return clock;}
	public SimState getState() {return state;}
	public void setThread(Thread thread) {this.thread = thread;}
	

	@Override
	public void run() {
		try {
			while(state != SimState.STOPPED) {
				update();
				Thread.sleep(50);
				clock++;
				changed();
				synchronized(this) {
					while(state == SimState.SUSPENDED) {
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public abstract void update();
}
