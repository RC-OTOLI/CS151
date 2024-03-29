package presentation;

import business.*;
//import framework.*; /*for future implementation*/

import javax.swing.*;
import java.awt.*;

public class BrickFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Brick model;
	private BrickPanel brickPanel;
	
	//Default AND minimum dimensions of window
	public static final int FRAME_WIDTH = 700;
	public static final int FRAME_HEIGHT = 500;

	public BrickFrame() {
		model = new Brick();
		brickPanel = new BrickPanel(model);
		Container cp = getContentPane();
		
		cp.add(brickPanel);
		
		setTitle("Brick CAD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
	}

	public static void main(String[] args) {
		BrickFrame brickFrame = new BrickFrame();
		brickFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		brickFrame.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		brickFrame.setVisible(true);
	}
}