package presentation;

import business.*;
//import framework.*; /*for future implementation*/

import java.awt.*;

public class FrontView extends BrickView {
	
	private static final long serialVersionUID = 1L;

	public FrontView(Brick b) {
		super(b);
		//Title space
		title.setText("Front View");
	}
	
	@Override
	//Draws rectangle in the top left corner
	public void paintComponent(Graphics gc) {
		Graphics2D gc2d = (Graphics2D)gc;
		myRectangle frontView = new myRectangle(
							   32.0, 32.0, 
				25*model.getWidth(), 25*model.getHeight());
		frontView.draw(gc2d);
	}
	
}
