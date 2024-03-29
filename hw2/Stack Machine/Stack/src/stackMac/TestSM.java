package stackMac;
public class TestSM {

	// f() = 5x^2 - 3
	public static void test0(Double x) {
		// create an empty program
		Program p0 = new Program();
		// add commands to p:
		p0.add(new Push(3.0));
		p0.add(new Push(x));
		p0.add(new Push(x));
		p0.add(new Push(5.0));
		p0.add(new Mul());
		p0.add(new Mul());
		p0.add(new Sub());
		// now execute
		StackMachine.execute(p0);
	}

	// f(x) = x^3 + 3x^2 - 2x + 1
	public static void test1(Double x) {
		//Create an empty program
		Program p1 = new Program();
		p1.add(new Push(1.0));
		p1.add(new Push(x));
		p1.add(new Push(2.0));
		p1.add(new Mul());
		p1.add(new Push(x));
		p1.add(new Push(x));
		p1.add(new Push(3.0));
		p1.add(new Mul());
		p1.add(new Mul());
		p1.add(new Push(x));
		p1.add(new Push(x));
		p1.add(new Push(x));
		p1.add(new Mul());
		p1.add(new Mul());
		p1.add(new Add());
		p1.add(new Sub());
		p1.add(new Add());
		// now execute
		StackMachine.execute(p1);
	}
	
	public static void divby0() {
		Program p2 = new Program();
		p2.add(new Push(0.0));
		p2.add(new Push(-9.9));
		p2.add(new Div());
		StackMachine.execute(p2);
	}
	
	public static void empty() {
		Program p4 = new Program();
		p4.add(new Push(9.0));
		p4.add(new Pop());
		p4.add(new Pop());
		StackMachine.execute(p4);
	}
	
	public static void shortStack() {
		Program p5 = new Program();
		p5.add(new Push(9.0));
		p5.add(new Div());
		StackMachine.execute(p5);
	}

	public static void main(String[] args) {
		test1(2.0); // [17.0]
		test1(5.0); // [191.0]

		test0(2.0); // [17.0]
		test0(4.0); // [77]
		
		//divby0();
		//empty();
		shortStack();
	}

}