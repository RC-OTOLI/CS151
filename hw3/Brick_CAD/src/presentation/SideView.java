package presentation;

import business.*;
//import framework.*; /*for future implementation*/

import java.awt.*;

public class SideView extends BrickView {
	
	private static final long serialVersionUID = 1L;

	public SideView(Brick b) {
		super(b);
		//Title space
		title.setText("Side View");
	}
	
	@Override
	//Draws rectangle in the top right corner
	public void paintComponent(Graphics gc) {
		Graphics2D gc2d = (Graphics2D)gc;
		myRectangle sideView = new myRectangle(
				getWidth()-32-25*model.getDepth(), 32.0,
							  25*model.getDepth(), 25*model.getHeight());
		sideView.draw(gc2d);
	}
	
}
