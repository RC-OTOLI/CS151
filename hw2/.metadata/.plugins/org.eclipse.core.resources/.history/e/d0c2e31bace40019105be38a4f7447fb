package ToD;

public class StabStrategy extends Strategy {

	
	public StabStrategy() {
		super();
	}
	
	
	public StabStrategy(Gladiator owner) {
		super();
		this.setOwner(owner);
	}
	
	
	@Override
	public void strike(Gladiator other) {
		//Placeholder damage algorithm for Stab
		int otherHealth = other.getHealth();
		int ownerHealth = owner.getHealth();
		
		int damage = Utilities.RNGDamage(ownerHealth/2);
		
		other.setHealth(otherHealth-damage);
		
		System.out.println(
			this.owner.getName() + 
			" stabs " + 
			other.getName());
	}
}
