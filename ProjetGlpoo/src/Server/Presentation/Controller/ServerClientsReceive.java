package Server.Presentation.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerClientsReceive implements Runnable {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private int State;
	
	public ServerClientsReceive(Socket socket) {
		this.socket = socket;
		try {
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		State = 0;
		Thread envoieMessage = new Thread(new ServerClientsSend(socket, out));
		
		String msg;
		while(true) {
			try {
				msg = in.readLine();
				
				switch(State) {
				
				case 0:
					
					if(msg.equals("LOGIN")) {
						
					}else if(msg.equals("SIGNIN")) {
						
					}
					
					break;
				case 1:
					
					break;
				
				default: break;
				
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
