package presentation;

import business.*;
//import framework.*; /*for future implementation*/

import java.awt.*;

public class TopView extends BrickView {
	
	private static final long serialVersionUID = 1L;

	public TopView(Brick b) {
		super(b);
		//Title space
		title.setText("Top View");
	}
	
	@Override
	//Draws rectangle in the bottom left corner
	public void paintComponent(Graphics gc) {
		Graphics2D gc2d = (Graphics2D)gc;
		myRectangle topView = new myRectangle(
								32.0, getHeight()-32-20*model.getDepth(),
				 25*model.getWidth(), 25*model.getDepth());
		topView.draw(gc2d);
	}
	
}
