package TRS.Client;

import java.net.*;

import java.io.*;

import java.util.*;

public class TRS_Client {
	private OutputStreamWriter sInput; // lesen vom socket
	private InputStreamReader sOutput; // schreiben auf socket
	private Socket socket;
	private Ui_ChatClient cg; // gui
	private String host; // server ip
	private int port; // server port

	/**
	 * Konstruktor
	 * 
	 * @param host
	 * @param port
	 * @param cg
	 */
	public TRS_Client(String host, int port/*, Ui_ChatClient cg*/) {
		this.host = host;
		this.port = port;
		//this.cg = cg;
	}

	/**
	 * Starten den Client, Listener und fragt nach dem Benutzernamen.
	 * 
	 * @return
	 */
	public boolean start() {
		try {// server verbindung aufbauen trial
			socket = new Socket(host, port);
			sInput =  new OutputStreamWriter(socket.getOutputStream(),"UTF-8");
			sOutput = new InputStreamReader(socket.getInputStream(),"UTF-8");
		} catch (Exception ec) {
			System.err.println(ec);
			return false;
		}
		new Listener().start();

		return true;
	}

	/**
	 * Versendet die Nachricht.
	 * 
	 * @param msg
	 */
	public void sendMessage(String msg) {
		try {
			//sOutput.writeObject(msg);
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
			while (true) {
				try {
					//String msg = (String) sInput.readObject();
					// cg.messages.addItem(msg);
				} catch (IOException e) {
					break;

				} catch (ClassNotFoundException e2) {

				}

			}

		}

	}
}
