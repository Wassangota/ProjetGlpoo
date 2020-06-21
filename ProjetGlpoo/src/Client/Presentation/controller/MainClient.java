package Client.Presentation.controller;

import java.io.IOException;
import java.net.Socket;

public class MainClient {

	private static Socket socket;
	private static Thread t;
	
	public MainClient() {
		System.out.println("Ceci est le client");
		start();
	}
	
	public void start() {
		
		try {
			socket = new Socket("127.0.0.1", 5213);
			
			t = new Thread(new ClientServerSend(socket));
			//t.start();
			
			t = new Thread(new ClientServerReceive(socket));
			//t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		new MainClient();
	}
	
}

