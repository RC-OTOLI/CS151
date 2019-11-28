package business;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class RoomGraphic {
	private Rectangle2D.Double room;
	private Rectangle2D.Double walls;
	//private Ellipse2D.Double player;
	
	public RoomGraphic(Double xc, Double yc, Double s) {
		walls = new Rectangle2D.Double(xc, yc, s, s);
		room = new Rectangle2D.Double(xc+s*.1, yc+s*.1, s*.8, s*.8);
		//player = new Ellipse2D.Double(xc+s*.25, yc+s*.25, s*.5, s*.5);
	}
	
	public void draw(Graphics2D gc) {
		Color oldColor = gc.getColor();
		gc.setColor(Color.BLACK);
		gc.fill(walls);
		gc.setColor(Color.BLUE);
		gc.fill(room);
		gc.setColor(oldColor);
	}
}