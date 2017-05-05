package ocsf;

import java.util.Scanner;

import com.lloseng.ocsf.client.AbstractClient;

/**
 * Client that connects to server and sends Strings
 * @author Supisara Chuthathumpitak
 */
public class Client extends AbstractClient{
	
	/**
	 * Initialize the Client.
	 * @param host is the host of the computer.
	 * @param port is the port of the server.
	 */
	public Client(String host, int port) {
		super(host, port);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lloseng.ocsf.client.AbstractClient#handleMessageFromServer(java.lang.Object)
	 */
	@Override
	protected void handleMessageFromServer(Object msg) {
		System.out.println(msg);
	}
	
	/**
	 * Start the program.
	 * @param args
	 */
	public static void main(String[] args) {
		String host = "10.2.12.83";
		int port = 5001;
		Client client = new Client(host, port);
		Scanner scanner = new Scanner(System.in);
		try{
			client.openConnection();
			while(client.isConnected()){
				client.sendToServer(scanner.nextLine());
			}
			client.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
