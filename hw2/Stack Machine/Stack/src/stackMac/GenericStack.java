package stackMac;

class GenericStack<T> {
	
	//Base genericStack on ArrayList rather than build from scratch. (Lazy, I know)
	private java.util.List<T> genericStack = new java.util.ArrayList<T>();
	
	public GenericStack() {	
	}
	
	public boolean push(T t) {
		return genericStack.add(t);
	}
	
	public T pop() throws EmptyStackException {
		
		T element;
		
		//Make sure that user isn't popping an empty stack
		try {
			element = genericStack.remove(genericStack.size()-1);
		}
		catch(IndexOutOfBoundsException e) {
			throw new EmptyStackException("Cannot pop from an empty stack!");
		}
		
		return element;
	}
	
	public T top() throws StackMachineException {
		
		T element;
		
		//Make sure that user isn't peeking at an empty stack
		try {
			element = genericStack.get(genericStack.size()-1);
		}
		catch(IndexOutOfBoundsException e) {
			throw new EmptyStackException("Cannot see the top of an empty stack!");
		}
		
		return element;
	}
	
	public void clear() {
		genericStack.clear();
	}
	
	@Override
	public String toString() {
		
		//Format output to: "[ arg1, arg2, ....., arg(n-1), arg(n) ]
		StringBuilder str = new StringBuilder("[");
		
		for(T t: this.genericStack)
			str.append(t + ", ");
		str.delete(str.length()-3, str.length()-1);
		str.append("]");
		
		return str.toString();
	}
}
