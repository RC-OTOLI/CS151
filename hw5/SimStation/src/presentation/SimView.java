package presentation;

import framework.Model;
import framework.Utilities;
import framework.View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;

import java.util.Observable;

public class SimView extends View {

	private static final long serialVersionUID = 1L;
		
	public SimView(Model m) {
		super(m);
		
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
	}
	
	
	@Override
	public void paintComponent(Graphics gc) {
		Graphics2D gc2d = (Graphics2D)gc;
		AgentGraphic ag;			
		
		//Populate the view with agents from the world
		for(Agent a: ((World)model).getAgents()) {
			ag = new AgentGraphic((double)a.xc, (double)a.yc);
			ag.draw(gc2d);
		}
	}
	
	
	@Override
	public void update(Observable subject, Object msg) {
		this.repaint();
	}
	
	
	class AgentGraphic {
		private Ellipse2D.Double agent;

		public AgentGraphic(Double xc, Double yc) {
			agent = new Ellipse2D.Double(xc, yc, 10d, 10d);
		}
		
		public void draw(Graphics2D gc) {
			Color oldColor = gc.getColor();
			gc.setColor(Color.MAGENTA);
//			DISCO MODE!
//			gc.setColor(new Color(Utilities.nextFloat(0, 1), Utilities.nextFloat(0, 1), Utilities.nextFloat(0, 1), Utilities.nextFloat(0.5f, 1)));
			gc.fill(agent);
			gc.setColor(oldColor);
		}
	}
}	