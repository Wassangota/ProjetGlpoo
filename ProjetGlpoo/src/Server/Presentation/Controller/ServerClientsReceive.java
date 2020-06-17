package Server.Presentation.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerClientsReceive implements Runnable {

	private Socket socket;
	private BufferedReader in;
	
	public ServerClientsReceive(Socket socket) {
		this.socket = socket;
		try {
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String msg;
		while(true) {
			try {
				msg = in.readLine();
				System.out.println("Client : "+msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
