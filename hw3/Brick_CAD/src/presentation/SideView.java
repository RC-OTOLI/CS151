package presentation;

import business.*;
//import framework.*; /*for future implementation*/

import java.awt.*;
import java.util.Observable;

import javax.swing.*;

public class SideView extends BrickView {
	
	private static final long serialVersionUID = 1L;

	public SideView(Brick b) {
		super(b);
		JPanel p = new JPanel();
		p.add(new JLabel("Side View"));
		this.add(p);
	}
	
	@Override
	public void paintComponent(Graphics gc) {
		Graphics2D gc2d = (Graphics2D)gc;
		myRectangle sideView = new myRectangle((int)(20*model.getDepth()), (int)(20*model.getHeight()));
		sideView.draw(gc2d);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.repaint();
	}
}
