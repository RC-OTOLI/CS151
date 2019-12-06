package echo;

import java.net.Socket;
import java.util.HashMap;

public class CacheHandler extends ProxyHandler {

	protected Correspondent peer;
	private static Cache cache = new Cache();

	public CacheHandler(Socket s) { super(s); }
	public CacheHandler() { super(); }
	
	public void initPeer(String host, int port) {
		peer = new Correspondent();
		peer.requestConnection(host, port);
	}

	@Override
	protected String response(String msg) {
		String resp = null;
		if(cache.search(msg) == null) {
			peer.send(msg);
			resp = peer.receive() + " from peer";
			
			cache.update(msg, resp);
			return resp;
		}
		else {
			resp = cache.get(msg) + " from cache";
		}
		
		return resp;
	}
	
	public static class Cache extends HashMap<String, String> {

		private static final long serialVersionUID = 1L;

		public synchronized String search(String request) {
			return this.get(request);
		}
		
		public synchronized void update(String request, String response) {
			this.put(request, response);
		}

	}
}