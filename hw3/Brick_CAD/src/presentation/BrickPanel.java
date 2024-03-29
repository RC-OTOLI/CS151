package presentation;

import business.*;
//import framework.*; /*for future implementation*/

import javax.swing.JPanel;
import java.awt.*;

public class BrickPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Brick model;
	private BrickView topView;
	private BrickView sideView;
	private BrickView frontView;
	private JPanel controlPanel;
	
	public BrickPanel(Brick b) {
		this.model = b;
		topView = new TopView(model);
		sideView = new SideView(model);
		frontView = new FrontView(model);
		controlPanel = new ControlPanel(model);
		
		setLayout(new GridLayout(2,2));
		this.add(controlPanel);
		this.add(topView);
		this.add(sideView);
		this.add(frontView);
	}
}
