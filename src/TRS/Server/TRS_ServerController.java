package TRS.Server;

import java.util.Map;

public class TRS_ServerController {
	static Map<String, Integer> usermap;
	static TRS_Server srv = new TRS_Server(5050, usermap);

	public static void main(String[] args) {
		ServerRun run = new ServerRun(srv, usermap);
		run.start();

	}

}