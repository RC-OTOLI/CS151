package ToD;

public class Tournament {

	public static void main(String[] args) {

		Gladiator sonya = new Gladiator("Sonya");
		Gladiator zena = new Gladiator("Zena");

		
		CompositeStrategy s1 = new CompositeStrategy();
		s1.add(new StabStrategy());
		s1.add(new StabStrategy());
		s1.add(new PoisonStrategy());
		sonya.setStrategy(s1);

		CompositeStrategy s2 = new CompositeStrategy();
		s2.add(new ShootStrategy());
		s2.add(new StabStrategy());
		s2.add(new PoisonStrategy());
		zena.setStrategy(s2);

		while(0 < zena.getHealth() && 0 < sonya.getHealth()) {
			sonya.attack(zena);
			zena.attack(sonya);
		}

		System.out.println("Results: ");
		System.out.println("   " + sonya);
		System.out.println("   " + zena);

	}

}

/*
 * Current damage algorithm based on attacker's health HEAVILY favors whoever attacks 1st.
 * Gladiators can attack while at 0 health by default meaning that it relies on implementation to limit ability to attack 
 */