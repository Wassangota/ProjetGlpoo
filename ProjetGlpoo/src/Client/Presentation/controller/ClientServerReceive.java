package Client.Presentation.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientServerReceive implements Runnable {

	private Socket socket;
	private BufferedReader in;
	
	public ClientServerReceive(Socket socket) {
		this.socket = socket;
		try {
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Singletons.setInput(in);
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
				System.out.println(msg);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

}
