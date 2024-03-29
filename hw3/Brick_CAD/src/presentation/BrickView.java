package presentation;

import business.*;
//import framework.*; /*for future implementation*/

import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class BrickView extends JComponent implements Observer {
	
	private static final long serialVersionUID = 1L;
	protected Brick model;
	protected JLabel title = new JLabel("Default Title");
	
	public BrickView(Brick b) {
		this.model = b;
		model.addObserver(this);
		//
		setLayout(new FlowLayout());
		this.add(title);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		//repaint the view based off the new state of the brick model
		this.repaint();
	}

}
