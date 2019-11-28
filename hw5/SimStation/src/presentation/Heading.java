package presentation;

import framework.*;

public enum Heading {
	//Enum fields
	NORTH("North"), 
	SOUTH("South"), 
	EAST("East"), 
	WEST("West");
	
	private String direction;
	//Implementation more easily supports addition of more refined directions such as NW, NNW, and so on.
	private static final Heading[] HEADINGS = values();
	private static final int SIZE = HEADINGS.length;
	
	Heading(String dir) {
		this.direction = dir;
	}
	
	public static Heading randHeading() {
		return HEADINGS[Utilities.nextInt(SIZE)];
	}
	
	public String getString() {
		return this.direction;
	}
}
