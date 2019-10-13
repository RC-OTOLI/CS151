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
	
	public BrickView(Brick b) {
		this.model = b;
		model.addObserver(this);
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
