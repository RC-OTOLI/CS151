package presentation;

import framework.AppPanel;
import framework.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimPanel extends AppPanel{
	
	private static final long serialVersionUID = 1L;

	private JTextField clock;
	private World world;
	
	public SimPanel (Model model, ActionListener listener) {
		super(model, listener);
		world = (World)model;

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridBagLayout());
		
		//constraints for the control panel elements
		c.gridx = 0;
		c.weighty = .2;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		
		/*-----------CLOCK-----------*/
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label = new JLabel("Clock: ");
		
		clock = new JTextField(""+(int)world.getClock());
		clock.setPreferredSize(new Dimension(50,20));
		
		panel.add(label);
		panel.add(clock);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		c.gridy = 0;
		controlPanel.add(panel, c);
		
		/*-----------START-----------*/
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton start = new JButton("Start");
		start.addActionListener(listener);
		
		panel.add(start);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		c.gridy++;
		controlPanel.add(panel, c);
		
		/*-----------SUSPEND-----------*/
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton suspend = new JButton("Suspend");
		suspend.addActionListener(listener);
		
		panel.add(suspend);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		c.gridy++;
		controlPanel.add(panel, c);
		
		/*-----------RESUME-------*/
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton resume = new JButton("Resume");
		resume.addActionListener(listener);
		
		panel.add(resume);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		c.gridy++;
		controlPanel.add(panel, c);
		
		/*-----------STOP-----------*/
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(listener);
		
		panel.add(stop);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		c.gridy++;
		controlPanel.add(panel, c);

		/*-----------NEW BIRD SIM-----------*/
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton birds = new JButton("New Birds");
		birds.addActionListener(listener);
		
		panel.add(birds);
		
		/*-----------NEW DRUNK SIM-----------*/		
		JButton drunk = new JButton("New Drunks");
		drunk.addActionListener(listener);
		
		panel.add(drunk);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		c.gridy++;
		controlPanel.add(panel, c);
		
		
		//ADD CONTROL PANEL
		//Constraints for the control panel as a whole
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = .5;
		controlPanel.setPreferredSize(new Dimension(world.SIZE, world.SIZE));
		this.add(controlPanel, c);
		
		JPanel simView = new JPanel();
		simView.setLayout(new GridLayout());
		simView.add(new SimView(model));
		simView.setPreferredSize(new Dimension(world.SIZE, world.SIZE));
		
		//ADD SIMVIEW
		//constraints for the SimView
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = .5;
		this.add(simView, c);	
	}


	@Override
	public void update(Observable subject, Object msg) {
		// TODO Auto-generated method stub
		super.update(subject, msg);
		clock.setText("" + (int)world.getClock());
	}	
}