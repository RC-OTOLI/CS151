package echo;

import java.net.Socket;

public class MathHandler extends RequestHandler {

	public MathHandler(Socket s) { super(s); }
	public MathHandler() { }
	// override in a subclass:
	protected String response(String msg) {
		String[] resp = msg.split("\\s+");
		Double result;
		switch(resp[0]) {
		case "add":
			result = 0d;
			for(int i = 1; i < resp.length; i++) result += Double.parseDouble(resp[i]);
			return result.toString();
		case "mul":
			result = 1d;
			for(int i = 1; i < resp.length; i++) result *= Double.parseDouble(resp[i]);
			return result.toString();
		case "sub":
			result = Double.parseDouble(resp[1]);
			if(resp.length > 2)
				for(int i = 2; i < resp.length; i++) result -= Double.parseDouble(resp[i]);
			return result.toString();
		case "div":
			result = Double.parseDouble(resp[1]);
			if(resp.length > 2)
				for(int i = 2; i < resp.length; i++) result /= Double.parseDouble(resp[i]);
			return result.toString();
		default:
			break;
		}
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
