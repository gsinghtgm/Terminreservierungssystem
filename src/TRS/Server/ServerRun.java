package TRS.Server;

import java.util.Map;

/**
 * Thread fuer den Server
 * 
 * @author Gurparkash
 * @version 15-03-18
 */
public class ServerRun extends Thread {
	TRS_Server server;

	public ServerRun(TRS_Server server, Map<String, Integer> usermap) {
		this.server = new TRS_Server(5050, usermap);
	}

	public void run() {
		server.start();
	}
}