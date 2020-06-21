package Server.Presentation.Controller;

import java.io.IOException;
import java.net.ServerSocket;

import Server.Presentation.Model.XmlMethods;

public class MainServer {
	
	private static int port = 5213;
	private static ServerSocket serverSocket;
	private static Thread mainThread;
	
	public MainServer() {
		System.out.println("Ceci est un serveur");
		start();
	}
	
	public void start() {
		XmlMethods.loadXMLData();
		//XmlMethods.createAccountlist();
		XmlMethods.readAccount();
		try {
			serverSocket = new ServerSocket(port);
			mainThread = new Thread(new BouclePrincipale(serverSocket));
			mainThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String args[]) {
		new MainServer();
	}

}
