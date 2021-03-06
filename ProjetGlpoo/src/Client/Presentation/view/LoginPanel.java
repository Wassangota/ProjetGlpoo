package Client.Presentation.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1481780085197891083L;

	@SuppressWarnings("deprecation")
	public LoginPanel(PrintWriter out, BufferedReader in, JFrame frame) {
		String msg;
		out.println("LOGIN");
		out.flush();
		try {
			msg = in.readLine();
			if(!msg.equals("OKTESTLOG")) {
				return;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setLayout(new GridLayout(5,3));
		setBackground(Color.BLACK);
		
		JPanel[][] panelHolder1 = new JPanel[5][3];
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<3;j++) {
				panelHolder1[i][j] = new JPanel(new GridLayout(2,1));
				panelHolder1[i][j].setBackground(new Color(0, 128, 255));
			}
		}
		
		JTextField login = new JTextField();
		login.setPreferredSize(new Dimension(100,25));
		JPasswordField password = new JPasswordField();
		password.setPreferredSize(new Dimension(100,25));
		
		JButton loginButton = new JButton("Login");
		loginButton.setPreferredSize(new Dimension(100,25));
		loginButton.addActionListener(e->{
			out.println(login.getText());
			out.println(password.getText());
			out.flush();
			try {
				String msgs = in.readLine();
				if(msgs.equals("OKLOG")) {
					System.out.println("Reussite");
					frame.setContentPane(new ChatWindowPanel(out, in, frame));
					frame.revalidate();
				}else {
					out.print("LOGIN");
					out.flush();
					msgs = in.readLine();
					if(!msgs.equals("OKTESTLOG")) {
						return;
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Login :" + login.getText()+"\nPassword "+password.getText());
		});
		
		panelHolder1[2][1].add(login);
		panelHolder1[2][1].add(password);
		panelHolder1[3][1].add(loginButton);
		
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<3;j++) {
				add(panelHolder1[i][j]);
			}
		}
	}
	
}
