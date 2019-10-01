package stackMac;

class GenericStack<T> {
	private java.util.List<T> genericStack = new java.util.ArrayList<T>();
	
	public GenericStack() {	
	}
	
	public boolean push(T t) {
		return genericStack.add(t);
	}
	
	public T pop() throws EmptyStackException {
		T element;
		try {
			element = genericStack.remove(genericStack.size()-1);
		}
		
		catch(IndexOutOfBoundsException e) {
			throw new EmptyStackException(e.getMessage());
		}
		
		return element;
	}
	
	public T top() throws StackMachineException {
		T element;
		try {
			element = genericStack.get(genericStack.size()-1);
		}
		
		catch(IndexOutOfBoundsException e) {
			throw new EmptyStackException(e.getMessage());
		}
		
		return element;
	}
	
	public void clear() {
		genericStack.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(T t: this.genericStack)
			str.append(t);
		
		return str.toString();
	}
}
