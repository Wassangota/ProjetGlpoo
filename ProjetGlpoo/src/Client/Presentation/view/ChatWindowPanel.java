package Client.Presentation.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ChatWindowPanel extends JPanel {
	
	JScrollPane scroll;
	
	public ChatWindowPanel(PrintWriter out, BufferedReader in, JFrame frame) {
		
		setLayout(new BorderLayout());
			
		JPanel leftPanel = new JPanel(new GridLayout(2,1));
		JPanel rightPanel = new JPanel(new BorderLayout());
		
		JPanel topleftPanel = new JPanel(new GridLayout(4,1));
		
		JPanel pseudo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton pseudoButton = new JButton("Gestion de compte");
		pseudo.add(pseudoButton);
		
		JPanel listContact = new JPanel(new GridLayout(1,2));
		JPanel contactform1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel contactform2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Object[] elements = new Object[]{"Wassil"};
		JComboBox<Object> selecContact = new JComboBox<Object>(elements);
		contactform1.add(selecContact);
		listContact.add(contactform1);
		JButton plus = new JButton("+");
		plus.addActionListener(e->{
			new AddContactFrame(out);
		});
		contactform2.add(plus);
		listContact.add(contactform2);
		listContact.setBorder(BorderFactory.createTitledBorder("Contact"));
		
		JPanel Discussion = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton createDisc = new JButton("Créer une discussion");
		
		JPanel chercherDisc = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel convs = new JPanel();
		DefaultListModel<String> listeConv = new DefaultListModel<String>();
		//remplir la liste
		List<String> listConvers = new ArrayList<String>();//this.getConversations(out, in);
		for(int i = 0;i<listConvers.size();i++) {
			listeConv.addElement(listConvers.get(i));
		}
		JList<String> listConv = new JList<String>(listeConv);
		scroll = new JScrollPane(listConv);
		JTextField chercherDiscussion = new JTextField();
		
		createDisc.addActionListener(e->{
			if(chercherDiscussion.getText().equals("") || chercherDiscussion.getText() != null) {
				out.println("ADDCONV");
				out.println(chercherDiscussion.getText());
				out.flush();
				try {
					TimeUnit.SECONDS.sleep(1);
					DefaultListModel<String> listeConve = new DefaultListModel<String>();
					//remplir la liste
					List<String> listConverse = this.getConversations(out, in);
					for(int i = 0;i<listConverse.size();i++) {
						listeConv.addElement(listConverse.get(i));
					}
					JList<String> listConve = new JList<String>(listeConve);
					scroll = new JScrollPane(listConve);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		Discussion.add(createDisc);
		
		
		chercherDiscussion.setColumns(25);
		chercherDisc.add(chercherDiscussion);
		chercherDisc.setBorder(BorderFactory.createTitledBorder("Non du contact avec qui crée la discussion"));
		
		topleftPanel.add(pseudo);
		topleftPanel.add(listContact);
		topleftPanel.add(Discussion);
		topleftPanel.add(chercherDisc);
		
		topleftPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
		
		
		
		scroll.setPreferredSize(new Dimension(270,320));
		convs.add(scroll);
		
		leftPanel.add(topleftPanel);
		leftPanel.add(convs);
		
		JPanel formPseudo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel pseudoConv = new JLabel("Pseudo");
		formPseudo.add(pseudoConv);
		rightPanel.add(formPseudo,BorderLayout.NORTH);
		
		JPanel conversation = new JPanel();
		DefaultListModel<String> messages = new DefaultListModel<String>();
		JList<String> listMessage = new JList<String>(messages);
		JScrollPane scrollMessage = new JScrollPane(listMessage);
		scrollMessage.setPreferredSize(new Dimension(890,550));
		conversation.add(scrollMessage);
		
		rightPanel.add(conversation,BorderLayout.CENTER);
		
		JPanel envoieMessage = new JPanel(new BorderLayout());
		JTextField message = new JTextField();
		JPanel formButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ButtonSend = new JButton("Send");
		formButton.add(ButtonSend);
		envoieMessage.add(message,BorderLayout.CENTER);
		envoieMessage.add(formButton,BorderLayout.EAST);
		
		rightPanel.add(envoieMessage,BorderLayout.SOUTH);
		
		rightPanel.setBorder(BorderFactory.createTitledBorder("Chat"));
	
		
		this.add(leftPanel,BorderLayout.WEST);
		this.add(rightPanel,BorderLayout.CENTER);
		
		
		
	}
	
	public List<String> getConversations(PrintWriter out, BufferedReader in){
		out.println("GETCONVS");
		out.flush();
		String msg;
		List<String> conversations = new ArrayList<String>();
		try {
			msg = in.readLine();
			while(msg.equals("add")) {
				msg = in.readLine();
				conversations.add(msg);
				msg = in.readLine();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return conversations;
	}
}
