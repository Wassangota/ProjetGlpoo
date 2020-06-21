package Server.Presentation.Model;

import java.util.ArrayList;
import java.util.List;

public class Conversation {
	
	private String identifiant;
	private List<String> listMsg;
	
	public Conversation(String identifiant) {
		this.identifiant = identifiant;
		listMsg = new ArrayList<String>();
	}

	public String getIdentifiant() {
		return this.identifiant;
	}
	
	public List<String> getMessage(){
		return this.listMsg;
	}
	
	public void addMessage(String msg) {
		this.listMsg.add(msg);
	}

}
