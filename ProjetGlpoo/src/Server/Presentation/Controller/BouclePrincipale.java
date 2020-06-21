package Server.Presentation.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BouclePrincipale implements Runnable{
	
	private ServerSocket serverSocket;
	private Socket socket;
	private Thread tempThread;
	
	
	public BouclePrincipale(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		Singletons.setBP(this);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				
				socket = serverSocket.accept();
				System.out.println("Client "+socket.getInetAddress()+" etablished connexion to the server.");
				
				//A modifier en dessous pour lancer le thread perso du client
				
				
				tempThread = new Thread(new ServerClientsReceive(socket));
				tempThread.start();
				
				//////////
				
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
