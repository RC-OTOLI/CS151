package ToD;

import java.util.List;
import java.util.ArrayList;

public class CompositeStrategy extends Strategy {

	//Holds a list of sub-strategies to be executed
	private List<Strategy> children = new ArrayList<Strategy>();
	
	@Override
	public void strike(Gladiator other) {
		//In the case where CompositeStrategy.strike() does as much damage as a generic strike
		//super.strike(other)
		
		//In the case where each sub-strategy has full damage capabilities
		//Execute the sub-strategies in order
		for (Strategy s: children)
			s.strike(other);
	}
	
	//Set the owners of all the strategies in children to this strategy's owner 
	@Override
	public void setOwner(Gladiator owner) {
		for (Strategy s: children)
			s.setOwner(owner);
	}
	
	public boolean add(Strategy s) {
		return children.add(s);
	}
}
