package presentation;

import business.*;
import framework.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Brick brick;
	private BrickController controller;
	private JTextField height, width, depth;
	private final int TEXT_FIELD_SIZE = 12;
	
	
	public ControlPanel(Brick b) {
		this.brick = b;
		controller = new BrickController(b);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		//2 columns, 4 rows
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//(0-1, 0): Title
		c.gridx = 0;		//Starting coordinates
		c.gridy = 0;
		c.weighty = .2;
		c.gridwidth = 2;	//Title spans the panel
		add(new JLabel("Dimensions (in inches)"), c);
		
		//(1, 0): "Set Height"
		c.gridy++;			//Next row
		c.gridwidth = 1;	//Reset span to 1 cell
		this.add(new JLabel("Set Height: "), c);
		
		//(1, 1): {brick.height}
		height = new JTextField(brick.getHeight().toString(), TEXT_FIELD_SIZE);
		height.addActionListener(controller);
		c.gridx++;			//next column
		this.add(height, c);
		
		//(0, 2): brick width
		c.gridx--;			//previous column
		c.gridy++;			//next row
		this.add(new JLabel("Set Width: "), c);
		
		//(1, 2): {brick.width}
		width = new JTextField(brick.getWidth().toString(), TEXT_FIELD_SIZE);
		width.addActionListener(controller);
		c.gridx++;			//next column
		this.add(width, c);
		
		//(0, 3): brick Depth
		c.gridx--;			//previous column
		c.gridy++;			//next row
		this.add(new JLabel("Set Depth: "), c);
		
		//(1, 3): {brick.Depth}
		depth = new JTextField(brick.getDepth().toString(), TEXT_FIELD_SIZE);
		depth.addActionListener(controller);
		c.gridx++;			//next column
		this.add(depth, c);
		
		//(0-1, 4): bottom row spacer
		c.gridx--;
		c.gridy++;
		this.add(new JPanel(), c);
	}
	
	
	
	public class BrickController implements ActionListener {

		private Brick brick;
		
		public BrickController(Brick model) {
			super();
			brick = model;
		}
		
		@Override
		//Only changes parameters if inputs are valid.
		//Otherwise, it restores the fields to their last good input
		public void actionPerformed(ActionEvent ae) {

			JTextField sourceField = (JTextField)ae.getSource();
			
			//Height alteration
			if(ae.getSource() == height) {
				try {
					//Edge case of accidental double/float casting in text field needs to be handled here
					if(height.getText().toLowerCase().contains("d") || height.getText().toLowerCase().contains("f")) 
						throw new NumberFormatException();
					
					Double h = Double.valueOf(height.getText());
					brick.setHeight(h);
					
				} catch(NumberFormatException e) {
					sourceField.setText(brick.getHeight().toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be numeric", "Number Format Exception", JOptionPane.INFORMATION_MESSAGE);
					
				} catch(NonPositiveException e) {
					sourceField.setText(brick.getHeight().toString());
					JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Dimension", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
			
			//Width alteration
			else if(ae.getSource() == width) {
				try {
					//Edge case of accidental double/float casting in text field needs to be handled here
					if(width.getText().toLowerCase().contains("d") || width.getText().toLowerCase().contains("f")) 
						throw new NumberFormatException();
					Double w = Double.valueOf(width.getText());
					brick.setWidth(w);
					
				} catch(NumberFormatException e) {
					sourceField.setText(brick.getWidth().toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be numeric", "Number Format Exception", JOptionPane.INFORMATION_MESSAGE);
					
				} catch(NonPositiveException e) {
					sourceField.setText(brick.getWidth().toString());
					JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Dimension", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
			
			//Depth alteration
			else if(ae.getSource() == depth) {
				try {
					//Edge case of accidental double/float casting in text field needs to be handled here
					if(depth.getText().toLowerCase().contains("d") || depth.getText().toLowerCase().contains("f")) 
						throw new NumberFormatException();
					
					Double d = Double.valueOf(depth.getText());
					brick.setDepth(d);
					
				} catch(NumberFormatException e) {
					sourceField.setText(brick.getDepth().toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be numeric", "Number Format Exception", JOptionPane.INFORMATION_MESSAGE);
					
				} catch(NonPositiveException e) {
					sourceField.setText(brick.getDepth().toString());
					JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Dimension", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		}
	}
}
