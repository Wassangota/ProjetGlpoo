package Client.Presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Change_Password_UsernameGui extends JFrame{

	public Change_Password_UsernameGui()  {
		
	    JFrame frame = new JFrame("Edition profil");
	    JPanel panel = new JPanel(new GridLayout(4,2));
	    JPanel panel2 = new JPanel(new GridLayout(3,1));
	    
        frame.setSize(new Dimension(400,800));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        frame.add(panel);
        frame.add(panel2);
        frame.revalidate();
        frame.setVisible(true);
        
      
        JLabel lab1 = new JLabel("Nouveau mot de passe :");
        panel.add(lab1);
        
        JPasswordField pwd = new JPasswordField();
        panel.add(pwd);
        
        JLabel lab2 = new JLabel("Confirmer le mot de passe :");
        panel.add(lab2);
        
        JPasswordField cpwd = new JPasswordField();
        panel.add(cpwd);
        
        JButton but1 = new JButton("Confirmer");
        panel.add(but1);  
        
        JLabel lab3 = new JLabel ("Nouveau pseudo");
        panel2.add(lab3);
        
        TextField newusername= new TextField ();
        panel2.add(newusername);
        
        JButton but2 = new JButton("Confirmer");
        panel2.add(but2); 
        
        
        frame.pack();
    

	}
	
	public static void main(String args[]) {
		new Change_Password_UsernameGui();
	}
	

}
