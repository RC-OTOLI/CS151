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
		super.strike(other);
		
		System.out.println(
			owner.getName() +
			" shoots " +
			other.getName());
	}
}
