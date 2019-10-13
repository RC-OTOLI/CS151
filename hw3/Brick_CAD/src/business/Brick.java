package business;

//import framework.*; /*for future implementation*/

import java.util.Observable;

public class Brick extends Observable {
	private Double height = 2.25d;
	private Double width = 8d;
	private Double depth = 3.625d;
	
	public Brick() {
		super();
	}
	
	public Double getHeight() {
		return height;
	}

	public Double getWidth() {
		return width;
	}

	public Double getDepth() {
		return depth;
	}
	
	public void setHeight(Double h) {
		this.height = h;
		setChanged();
		notifyObservers();
	}
	
	public void setWidth(Double w) {
		this.width = w;
		setChanged();
		notifyObservers();
	}
	
	public void setDepth(Double d) {
		this.depth = d;
		setChanged();
		notifyObservers();
	}	
}