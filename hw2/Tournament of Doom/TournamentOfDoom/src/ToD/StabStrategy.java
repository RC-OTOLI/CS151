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
		super.strike(other);
		
		System.out.println(
			this.owner.getName() + 
			" stabs " + 
			other.getName());
	}
}
