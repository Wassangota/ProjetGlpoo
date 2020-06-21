package Client.Presentation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientServerSend implements Runnable{

	@SuppressWarnings("unused")
	private Socket socket;
	private PrintWriter out;
	private Scanner sc;
	
	public ClientServerSend(Socket socket) {
		this.socket = socket;
		try {
			this.out = new PrintWriter(socket.getOutputStream());
			Singletons.setOutput(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String msg;
		sc = new Scanner(System.in);
		while(true) {
			msg = sc.nextLine();
			out.println(msg);
			out.flush();
		}
	}

}
