package ToD;

/*
 *	Legacy class; 
 *	Implemented via custom adapter class, 
 *	SpitFireAdapter 
 */

class SpitFire {
	
	public SpitFire() {}
	
	public void fight(Gladiator attacker, Gladiator victim) {
		System.out.println(
				attacker.getName() +
				" is spitting fire at " +
				victim.getName());
	}
}
