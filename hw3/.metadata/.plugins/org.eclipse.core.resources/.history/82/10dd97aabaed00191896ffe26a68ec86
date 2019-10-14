package business;

//import framework.*; /*for future implementation*/

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class myRectangle {
	private int width, height;
	private Rectangle2D.Double view;
	private static final int BUFFER_TOP = 32, BUFFER_LEFT = 10;
	
	public myRectangle(int w, int h) {
		this.width = w;
		this.height = h;
		
		view = new Rectangle2D.Double(BUFFER_LEFT, BUFFER_TOP, BUFFER_LEFT+width, BUFFER_TOP+height);
	}
	
	public void draw(Graphics2D gc) {
		Color oldColor = gc.getColor();
		gc.setColor(Color.red);
		gc.fill(view);
		gc.setColor(oldColor);
	}
}
