package ToD;

public abstract class Strategy {
	protected Gladiator owner;
	
	public void setOwner(Gladiator owner) {
		this.owner = owner;
	}
	
	public void strike(Gladiator other) {
		//Placeholder default damage algorithm
		int otherHealth = other.getHealth();
		int ownerHealth = owner.getHealth();
		
		int damage = Utilities.RNGDamage(ownerHealth/5);
		
		other.setHealth(otherHealth-damage);
	}
	
}
