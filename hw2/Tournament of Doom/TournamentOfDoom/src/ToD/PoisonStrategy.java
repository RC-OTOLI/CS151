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
		super.strike(other);
		
		System.out.println(
			owner.getName() +
			" poisonins " +
			other.getName());
	}

}
