package presentation;

import business.*;
//import framework.*; /*for future implementation*/

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
		setLayout(new GridLayout(3,2));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		//(1, 1): "Set Height"
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		p.add(new JLabel("Set Height"));
		this.add(p);
		
		//(1, 2): {brick.height}
		p = new JPanel();
		p.setLayout(new GridBagLayout());
		height = new JTextField(brick.getHeight().toString(), TEXT_FIELD_SIZE);
		height.addActionListener(controller);
		p.add(height);
		this.add(p);
		
		//(2, 1): brick width
		p = new JPanel();
		p.setLayout(new GridBagLayout());
		p.add(new JLabel("Set Width"));
		this.add(p);
		
		//(2, 2): {brick.width}
		p = new JPanel();
		p.setLayout(new GridBagLayout());
		width = new JTextField(brick.getWidth().toString(), TEXT_FIELD_SIZE);
		width.addActionListener(controller);
		p.add(width);
		this.add(p);
		
		//(3, 1): brick Depth
		p = new JPanel();
		p.setLayout(new GridBagLayout());
		p.add(new JLabel("Set Depth"));
		this.add(p);
		
		//(3, 2): {brick.Depth}
		p = new JPanel();
		p.setLayout(new GridBagLayout());
		depth = new JTextField(brick.getDepth().toString(), TEXT_FIELD_SIZE);
		depth.addActionListener(controller);
		p.add(depth);
		this.add(p);		
	}
	
	public class BrickController implements ActionListener {

		private Brick brick;
		private Double lastGoodHeight, lastGoodWidth, lastGoodDepth;
		
		public BrickController(Brick model) {
			super();
			brick = model;
			lastGoodHeight = model.getHeight();
			lastGoodWidth = model.getWidth();
			lastGoodDepth = model.getDepth();
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			//String cmd = ae.getActionCommand();
			JTextField sourceField = (JTextField)ae.getSource();
			if(ae.getSource() == height) {
				try {
					Double h = Double.valueOf(height.getText());
					if(h <= 0 ) throw new NonPositiveException("");
					brick.setHeight(h);
					lastGoodHeight = h;
				} catch(NumberFormatException e) {
					sourceField.setText(lastGoodHeight.toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be numeric");
				} catch(NonPositiveException e) {
					sourceField.setText(lastGoodHeight.toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be non-zero and possitive");
				}
			}
			else if(ae.getSource() == width) {
				try {
					Double w = Double.valueOf(width.getText());
					if(w <= 0 ) throw new NonPositiveException("");
					brick.setWidth(w);
					lastGoodWidth = w;
				} catch(NumberFormatException e) {
					sourceField.setText(lastGoodWidth.toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be numeric");
				} catch(NonPositiveException e) {
					sourceField.setText(lastGoodWidth.toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be non-zero and possitive");
				}
			}
			else if(ae.getSource() == depth) {
				try {
					Double d = Double.valueOf(depth.getText());
					if(d <= 0 ) throw new NonPositiveException("");
					brick.setDepth(d);
					lastGoodDepth = d;
				} catch(NumberFormatException e) {
					sourceField.setText(lastGoodDepth.toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be numeric");
				} catch(NonPositiveException e) {
					sourceField.setText(lastGoodDepth.toString());
					JOptionPane.showMessageDialog(null, "Dimensions must be non-zero and possitive");
				}
			}
		}
	}
}
