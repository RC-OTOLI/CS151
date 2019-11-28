package presentation;


public class SimStation {

	public static void main(String[] args) {
		
		//Default to a "birds" simulation
		//Can switch simulation setups inside program
		SimFrame sf = new SimFrame(new SimFactory());
		
		
		//Lock window size to not break world display
		sf.setResizable(false);
		sf.pack();
		sf.display();
	}

}
