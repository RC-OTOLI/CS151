package business;

//import framework.*; /*for future implementation*/

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class myRectangle {

	private Rectangle2D.Double view;
	
	public myRectangle(Double xc, Double yc, Double w, Double h) {
		view = new Rectangle2D.Double(xc, yc, w, h);
	}
	
	public void draw(Graphics2D gc) {
		Color oldColor = gc.getColor();
		gc.setColor(Color.red);
		gc.fill(view);
		gc.setColor(oldColor);
	}
}
