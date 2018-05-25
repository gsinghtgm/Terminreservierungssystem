package TRS.Server;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.Session;

import TRS.*;

public class TRS_Server {
	private static int connectionid;// id fuer jeweiligen verbundenen client
	private int port;// Portadresse
	private boolean keepGoing;
	private ArrayList<ClientThread> al; // Collection fuer Clients
	public Map<String, Integer> usermap;
	private TRS.FactoryBuilder fb = new TRS.FactoryBuilder();
	private Session session = fb.session;

	public boolean loginUser(String email, String password) {
		return new TRS.LoginUser().loginUser(email, password, this.session);
	}

	public boolean createUser(String firstname, String lastname, String email, String password) {
		return new TRS.CreateUser().createUser(firstname, lastname, email, password, this.session);
	}

	public void close() {
		fb.factory.close();
	}

	public static void main(String args[]) {
		TRS_Server srv = new TRS_Server();
		if (srv.loginUser("gsingh@student.tgm.ac.at", "gsingh123"))
			System.out.println("GG");
		srv.close();
	}

	public class ClientThread extends Thread {

	}
}
