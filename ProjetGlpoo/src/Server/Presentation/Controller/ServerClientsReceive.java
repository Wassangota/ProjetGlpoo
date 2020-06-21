package Server.Presentation.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Server.Presentation.Model.Account;
import Server.Presentation.Model.XmlMethods;

public class ServerClientsReceive implements Runnable {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private int State;
	private String identifiant;
	
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
		boolean continuer = true;
		String msg;
		while(continuer) {
			try {
				msg = in.readLine();
				
				switch(State) {
				
				case 0:
					
					if(msg.equals("LOGIN")) {
						
						out.println("OKTESTLOG");
						out.flush();
						String id = in.readLine();
						String pw = in.readLine();
						if(XmlMethods.testLoginAccount(id,pw)) {
							out.println("OKLOG");
							out.flush();
							State = 1;
							this.identifiant = id;
							envoieMessage.start();
						}else {
							out.println("ERROR");
							out.flush();
						}
						
					}else if(msg.equals("SIGNIN")) {
						out.println("OK");
						out.flush();
						String id = in.readLine();
						String mdp = in.readLine();
						String pseudo = in.readLine();
						String test = XmlMethods.testNewAccount(id,pseudo);
						if(test.equals("OK")) {
							XmlMethods.addAccount(new Account(id,mdp,pseudo));
							XmlMethods.writeAccount();
							XmlMethods.readAccount();
							System.out.println("ajoutcompte");
						}
						out.println(test);
						out.flush();
						System.out.println("ID:"+id+" mdp:"+mdp+" pseudo:"+pseudo);
					}
					
					break;
				case 1:
					
					if(msg.equals("GETCONTACT")) {
						Account compte = XmlMethods.getAccount(identifiant);
						for(int j = 0;j<compte.getContact().size();j++) {
							out.println("Add");
							out.println(XmlMethods.getPseudoOfAccount(compte.getContact().get(j)));
							out.flush();
						}
						out.println("stop");
						out.flush();
					}else if(msg.equals("ADDCONV")) {
						msg = in.readLine();
						XmlMethods.addConversation(identifiant,msg);
					}else if(msg.equals("GETCONVS")) {
						Account compte = XmlMethods.getAccount(identifiant);
						for(int j = 0;j<compte.getConversations().size();j++) {
							out.println("Add");
							out.println(compte.getConversations().get(j));
							out.flush();
						}
					}
					
					break;
				
				default: break;
				
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				continuer = false;
			}
		}
	}

}
