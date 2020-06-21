package Server.Presentation.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerClientsSend implements Runnable{

	private Socket socket;
	private PrintWriter out;
	private Scanner sc;
	
	public ServerClientsSend(Socket socket, PrintWriter out) {
		this.socket = socket;
		this.out = out;
	}
	
	@Override
	public void run() {
		sc = new Scanner(System.in);
		String msg;
		/*while(true) {
			msg = sc.nextLine();
			this.out.println("Serveur : "+msg);
			this.out.flush();
		}*/
	}

}
