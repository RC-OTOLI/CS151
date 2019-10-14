package ToD;

public class ShootStrategy extends Strategy {

	public ShootStrategy() {
		super();
	}
	
	
	public ShootStrategy(Gladiator owner) {
		super();
		this.setOwner(owner);
	}
	
	
	@Override
	public void strike(Gladiator other) {
		//Placeholder damage algorithm for Shoot
		int otherHealth = other.getHealth();
		int ownerHealth = owner.getHealth();
		
		int damage = Utilities.RNGDamage(ownerHealth/2);
		
		other.setHealth(otherHealth-damage);
		
		System.out.println(
			owner.getName() +
			" shoots " +
			other.getName());
	}
}
