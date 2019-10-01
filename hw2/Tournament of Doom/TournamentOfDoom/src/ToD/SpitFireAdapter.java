package ToD;

/*
 * Adapts SpitFire class to work with Strategy class structure
 */

public class SpitFireAdapter extends Strategy {

	private SpitFire adaptee;
	
	public SpitFireAdapter() {
		super();
	}
	
	
	public SpitFireAdapter(Gladiator owner) {
		super();
		this.setOwner(owner);
	}
	
	
	@Override
	public void strike(Gladiator other) {
		//Placeholder damage algorithm for SpitFire
		int otherHealth = other.getHealth();
		int ownerHealth = owner.getHealth();
		
		int damage = Utilities.RNGDamage(ownerHealth/2);
		
		other.setHealth(otherHealth-damage);
		
		adaptee.fight(owner, other);
	}

}
