package presentation;

import business.Simulation;
import framework.AppFactory;
import framework.AppFrame;
import framework.Model;
import framework.Utilities;

import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class SimFrame extends AppFrame {
		
	private static final long serialVersionUID = 1L;

	public SimFrame(AppFactory factory) {
		super(factory);
		this.getContentPane().add(factory.makePanel(model, this));
	}

	public SimFrame(AppFactory factory, String type, int numAgents) {
		super(factory);
		model = ((SimFactory)factory).makeModel(type, numAgents);
		this.getContentPane().add(factory.makePanel(model, this));
	}
	
	@Override
	public void setModel(Model model) {
		// used by open and new, details below
		((Simulation)(this.model)).copy(model);
	}
	
	//Override to add two versions of "new"
	@Override
	protected JMenuBar createMenuBar() {
		JMenuBar bar = new JMenuBar();
		// add file, edit, and help menus
		JMenu fileMenu = Utilities.makeMenu("File", new String[] {"New Birds", "New Drunks", "Save", "SaveAs", "Open", "Quit"}, this);
		JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
		JMenu helpMenu = Utilities.makeMenu("Help", new String[] {"Help", "About"}, this);
		
		// now add menus to bar
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(helpMenu);
		
		add(bar);
		
		return bar;
	}
	
	//Override to handle two versions of "new"
	@Override
	public void actionPerformed(ActionEvent ae) {
		String cmmd = ae.getActionCommand();
	    
		if (cmmd == "New Birds") {
	        Utilities.saveChanges(model);
	        setModel(((SimFactory)factory).makeModel("Bird", 150));
	        // needed cuz setModel sets to true:
	        model.setUnsavedChanges(false);
	     } else if(cmmd == "New Drunks") {
	    	 Utilities.saveChanges(model);
	        setModel(((SimFactory)factory).makeModel("Drunk", 150));
	        // needed cuz setModel sets to true:
	        model.setUnsavedChanges(false);
	     } else {
	        super.actionPerformed(ae);
	     }
	}
}
