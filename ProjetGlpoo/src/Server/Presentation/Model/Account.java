package Server.Presentation.Model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String identifiant;
	private String password;
	private String pseudo;
	private List<String> listContact;
	private List<String> listConversation;
	
	public Account(String id, String pw, String pseudo) {
		this.identifiant = id;
		this.password = pw;
		this.pseudo = pseudo;
		this.listContact = new ArrayList<String>();
		this.listConversation = new ArrayList<String>();
	}
	
	public Account(String id, String pw, String pseudo, List<String> listContact,
			List<String> listConversation) {
		this.identifiant = id;
		this.password = pw;
		this.pseudo = pseudo;
		this.listContact = listContact;
		this.listConversation = listConversation;
	}

	public List<String> getContact(){
		return this.listContact;
	}
	
	public void addContact(String id) {
		this.listContact.add(id);
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<String> getConversations(){
		return this.listConversation;
	}
	
	public void addConversation(String string) {
		this.listConversation.add(string);
	}

}
