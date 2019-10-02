package ToD;

/*
 * Collection of common functions used by many classes in the package
 */

public class Utilities {
	
	//Re-seed the RNG with a different number every time the program is run
	private static java.util.Random random = new java.util.Random(System.currentTimeMillis());
	
	//Determine random damage between 0 and upperLimit
	public static int RNGDamage(int upperLimit) {
		return random.nextInt(upperLimit+1);
	}
}
