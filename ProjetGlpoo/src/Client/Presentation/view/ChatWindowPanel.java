package Client.Presentation.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ChatWindowPanel extends JPanel {
	
	
	public ChatWindowPanel(PrintWriter out) {
		
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
		contactform2.add(plus);
		listContact.add(contactform2);
		listContact.setBorder(BorderFactory.createTitledBorder("Contact"));
		
		JPanel Discussion = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton createDisc = new JButton("Créer une discussion");
		Discussion.add(createDisc);
		
		JPanel chercherDisc = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JTextField chercherDiscussion = new JTextField();
		chercherDiscussion.setColumns(25);
		chercherDisc.add(chercherDiscussion);
		chercherDisc.setBorder(BorderFactory.createTitledBorder("Chercher une Discussion"));
		
		topleftPanel.add(pseudo);
		topleftPanel.add(listContact);
		topleftPanel.add(Discussion);
		topleftPanel.add(chercherDisc);
		
		topleftPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
		
		JPanel convs = new JPanel();
		DefaultListModel<String> listeConv = new DefaultListModel<String>();
		//remplir la liste
		JList<String> listConv = new JList<String>(listeConv);
		JScrollPane scroll = new JScrollPane(listConv);
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
		messages.addElement("Eric : Bonjour tout le monde");
		messages.addElement("Steven : ca va ?");
		Thread test = new Thread(new testMessage(messages));
		test.start();
		JList<String> listMessage = new JList<String>(messages);
		JScrollPane scrollMessage = new JScrollPane(listMessage);
		scrollMessage.setPreferredSize(new Dimension(860,550));
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
}
