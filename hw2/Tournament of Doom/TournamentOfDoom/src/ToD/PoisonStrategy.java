package ToD;

public class PoisonStrategy extends Strategy {

	public PoisonStrategy() {
		super();
	}
	
	
	public PoisonStrategy(Gladiator owner) {
		super();
		this.setOwner(owner);
	}

	
	@Override
	public void strike(Gladiator other) {
		//Placeholder damage algorithm for Poison
		int otherHealth = other.getHealth();
		int ownerHealth = owner.getHealth();
		
		int damage = Utilities.RNGDamage(ownerHealth/2);
		
		other.setHealth(otherHealth-damage);
		
		System.out.println(
			owner.getName() +
			" poisonins " +
			other.getName());
	}

}
