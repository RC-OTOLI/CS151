package echo;

import java.net.Socket;

public class RequestHandler extends Correspondent implements Runnable {
	public RequestHandler(Socket s) { super(s); }
	public RequestHandler() { }
	// override in a subclass:
	protected String response(String msg) {
		return "echo: " + msg;
	}
	public void run() {
		while(true) {
			
			String response = receive();
			
			if(response.contentEquals("quit")) break;

			send(response(response));
			Thread.yield();
		}
		close();
	}
}
