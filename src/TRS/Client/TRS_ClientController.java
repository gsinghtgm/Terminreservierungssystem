package TRS.Client;

public class TRS_ClientController {
	public static void main(String[] args) {
		TRS_Client client = new TRS_Client("localhost", 5050);
		client.start();
	}
}
