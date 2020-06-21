package Client.Presentation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddContactFrame extends JFrame{
	

	public AddContactFrame() {
		new JFrame("add contact");
		setSize(new Dimension(640,260));
		setResizable(false);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		revalidate();
		
		JPanel addContact = new JPanel(new GridLayout(3,1));
		JPanel nom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel prenom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel nomLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel prenomLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel nomForm = new JPanel(new GridLayout(1,2));
		JPanel prenomForm = new JPanel(new GridLayout(1,2));
		JPanel addButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton add = new JButton("add");
		JLabel surname = new JLabel("surname : ");
		JLabel first_name = new JLabel("first name : ");
		JTextField fieldSurname = new JTextField();
		fieldSurname.setColumns(25);
		JTextField fieldFirstName = new JTextField();
		fieldFirstName.setColumns(25);
		
		
		prenomLabel.add(first_name);
		prenom.add(fieldFirstName);
		
		nomLabel.add(surname);
		nom.add(fieldSurname);
		
		nomForm.add(nomLabel);
		nomForm.add(nom);
		
		prenomForm.add(prenomLabel);
		prenomForm.add(prenom);
		
		addButton.add(add);
		
		addContact.add(prenomForm);
		addContact.add(nomForm);
		addContact.add(addButton);
		
		addContact.setBorder(BorderFactory.createTitledBorder("add contact"));
		
		this.add(addContact);
		
		setVisible(true);
		
		
	}
}
