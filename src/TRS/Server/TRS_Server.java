package TRS.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
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

	public TRS_Server(int port, Map<String, Integer> usermap) {
		this.port = port;
		al = new ArrayList<ClientThread>();
		this.usermap = new HashMap<String, Integer>();
	}

	public boolean loginUser(String email, String password) {
		return new TRS.LoginUser().loginUser(email, password, this.session);
	}

	public boolean createUser(String firstname, String lastname, String email, String password) {
		return new TRS.CreateUser().createUser(firstname, lastname, email, password, this.session);
	}

	public void close() {
		fb.factory.close();
	}

	public void start() {
		keepGoing = true;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (keepGoing) {
				// wartet auf einen client
				System.out.println("Warte auf client");
				Socket socket = serverSocket.accept();
				if (!keepGoing)
					break;
				ClientThread t = new ClientThread(socket);
				al.add(t);// fügt client in die ArrayList hinzu
				t.start();// startet Thread
			}
			serverSocket.close();

			for (int i = 0; i < al.size(); ++i) {
				ClientThread ct = al.get(i);
				ct.close();
			}
		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
/*
	public static void main(String args[]) {
		TRS_Server srv = new TRS_Server();
		if (srv.loginUser("gsingh@student.tgm.ac.at", "gsingh123"))
			System.out.println("GG");
		srv.close();
	}*/

	public class ClientThread extends Thread {
		Socket socket;
		int id;
		String cm;// ChatMessage
		ObjectOutputStream sOutput;
		ObjectInputStream sInput;
		String username;

		public ClientThread(Socket socket) {
			id = ++connectionid;// ++ Berechnung vorher
			this.socket = socket;
			try {
				sOutput = new ObjectOutputStream(socket.getOutputStream());
				sInput = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void close() {
			// TODO Auto-generated method stub

			try {
				if (sOutput != null)
					sOutput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (sInput != null)
					sInput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
