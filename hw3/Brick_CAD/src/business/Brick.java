package business;

import framework.*;

import java.util.Observable;

public class Brick extends Observable {
	
	//Default dimensions: Standard construction brick US
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
	
	public void setHeight(Double h) throws NonPositiveException {
		if(h <= 0 ) throw new NonPositiveException("Height cannot be less than or equal to 0");
		this.height = h;
		setChanged();
		notifyObservers();
	}
	
	public void setWidth(Double w) throws NonPositiveException{
		if(w <= 0 ) throw new NonPositiveException("Width cannot be less than or equal to 0");
		this.width = w;
		setChanged();
		notifyObservers();
	}
	
	public void setDepth(Double d) throws NonPositiveException{
		if(d <= 0 ) throw new NonPositiveException("Depth cannot be less than or equal to 0");
		this.depth = d;
		setChanged();
		notifyObservers();
	}	
}