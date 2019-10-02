package ToD;

/*
 * Entities that fight each other to lower other's health.
 * Once one's health reaches 0, they are considered dead.
 * Use "strategies" to damage opponent in various ways.
 */

public class Gladiator {
	private String name;
	private int health;
	private Strategy strategy;
	
	
	public Gladiator(String name) {
		this.name = name;
		//New gladiators all have the same health
		this.health = 100;
	}

	
	public String getName() {
		return name;
	}
	
	
	public int getHealth() {
		return this.health;
	}
	
	
	public void setHealth(int health) {
		//Limit the range of health to 0-100
		if(health > 100) this.health = 100;
		else if(health < 0) this.health = 0;
		
		else this.health = health;
	}

	
	public Strategy getStrategy() {
		return strategy;
	}

	
	//manages bidirectional association with a strategy
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
		this.strategy.setOwner(this);
	}
	
	//Reduce the health of other gladiators
	public void attack(Gladiator other) {
		//Disable attack abilities if either Gladiator is 'dead'
		if(this.health > 0 || !(other.getHealth() == 0)) {
			this.strategy.strike(other);
			System.out.println(other.getName() + "'s health = " + other.getHealth());
		}
	}
	
	
	@Override
	public String toString() {
		return ("Name: " + this.name + "\tHealth: " + this.health);
	}
}
