package trs.Client;

import java.net.*;

import java.io.*;
import javax.json.Json;
import javax.json.JsonObject;

public class TRS_Client {
	private OutputStreamWriter sOutput; // lesen vom socket
	private BufferedReader sInput; // schreiben auf socket
	private Socket socket;
	private String host; // server ip
	private int port; // server port
	boolean authenticated = false;

	/**
	 * Konstruktor
	 * 
	 * @param host
	 * @param port
	 * @param cg
	 */
	public TRS_Client(String host, int port/* , Ui_ChatClient cg */) {
		this.host = host;
		this.port = port;
		// this.cg = cg;
	}

	/**
	 * Starten den Client, Listener und fragt nach dem Benutzernamen.
	 * 
	 * @return
	 */
	public boolean start() {
		try {// server verbindung aufbauen trial
			socket = new Socket(host, port);
			sOutput = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			sInput = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		} catch (Exception ec) {
			System.err.println(ec);
			return false;
		}
		new Listener().start();

		return true;
	}

	/**
	 * Versendet den Login.
	 * 
	 * @param msg
	 */
	public void login(String username, String password) {
		JsonObject json = Json.createObjectBuilder().add("username", username).add("password", password).build();
		try {
			sOutput.write(json.toString() + "\n");
			sOutput.flush();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	/**
	 * Zum schließen der Verbindung
	 */
	public void disconnect() {
		try {
			if (sInput != null)
				sInput.close();
		} catch (Exception e) {
		}
		try {
			if (sOutput != null)
				sOutput.close();
		}

		catch (Exception e) {
		}
		try {
			if (socket != null)
				socket.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Listener Klasse, hört dem Server zu und schreib eingehnde Nachrichten in die
	 * GUI.
	 * 
	 * @author Gurparkash
	 *
	 */
	class Listener extends Thread {
		public void run() {
			try {
				String msg = sInput.readLine();
				while (true) {
					if (msg.equals("erfolgreich"))
						setAuthenticated(true);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean autheticated) {
		this.authenticated = autheticated;
	}
}
