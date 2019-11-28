package buffers;

import java.util.*;

public class Buffer {

	private List<Message<String>> buffer = new LinkedList<Message<String>>();
	public int CAPACITY = 3;
			
	public synchronized boolean write(Message<String> msg) { 
		Utils.sleep(100);
		boolean success = false;
		
		while (buffer.size() >= CAPACITY) {
			try {
				wait();	//Wait for a message to be read
			} catch(InterruptedException ie) {
				System.err.println(ie.getMessage());
			}
		}
		
		if (buffer.size() < CAPACITY) {
			buffer.add(msg);
			success = true;
		}
		Utils.sleep(50);
		notify();
		return success;
	}
	
	public synchronized Message<String> read() { 
		Utils.sleep(50);
		
		while (buffer.isEmpty()) {
			try {
				wait();	//Wait for a message to be written
			} catch(InterruptedException ie) {
				System.err.println(ie.getMessage());
			}
		}
		
		Message<String> res = (buffer.isEmpty())? null: buffer.remove(0); 
		Utils.sleep(100);
		notify();
		return res;
	}
	
	public String toString() { return buffer.toString(); }

}