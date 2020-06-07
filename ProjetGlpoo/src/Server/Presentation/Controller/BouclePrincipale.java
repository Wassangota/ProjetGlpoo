package Server.Presentation.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BouclePrincipale implements Runnable{
	
	private ServerSocket serverSocket;
	private Socket socket;
	
	public BouclePrincipale(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				
				socket = serverSocket.accept();
				System.out.println("Client "+socket.getInetAddress()+" etablished connexion to the server.");
				
				//A modifier en dessous pour lancer le thread perso du client
				
				//////////
				
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
