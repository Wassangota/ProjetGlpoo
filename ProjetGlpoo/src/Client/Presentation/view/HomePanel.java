package Client.Presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class HomePanel extends JPanel{


		/**
	 * 
	 */
	
	private static final long serialVersionUID = 3138392320751424537L;
	
	private BufferedReader in;
	private PrintWriter out;

		public HomePanel(PrintWriter out, BufferedReader in, JFrame frame) {
			
			this.out = out;
			this.in = in;
			
			setLayout(new GridLayout(5,2));
			setBackground(Color.BLACK);
			
			JPanel[][] panelHolder1 = new JPanel[5][3];
			for(int i = 0;i<5;i++) {
				for(int j = 0;j<3;j++) {
					panelHolder1[i][j] = new JPanel(new GridLayout(2,1));
					panelHolder1[i][j].setBackground(new Color(0, 128, 255));
				}
			}
			
			JButton loginButton = new JButton("Login");
			loginButton.setPreferredSize(new Dimension(100,25));
			  loginButton.addActionListener(e->{
				  	frame.setContentPane(new LoginPanel(out, in, frame));
					frame.revalidate();
				});
			
			
			JButton createAccountButton = new JButton("Create account");
			createAccountButton.setPreferredSize(new Dimension(100,25));
			createAccountButton.addActionListener(e->{
				createAccount();
			});
			
			panelHolder1[2][1].add(createAccountButton);
			panelHolder1[3][1].add(loginButton);
			
			for(int i = 0;i<5;i++) {
				for(int j = 0;j<3;j++) {
					add(panelHolder1[i][j]);
				}
			}
		}
		
		@SuppressWarnings("deprecation")
		public void createAccount() {
			String msg;
			out.println("SIGNIN");
			out.flush();
			try {
				msg = in.readLine();
				if(!msg.equals("OK")) {
					return;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
	        JFrame newFrame = new JFrame("Create account");
	        newFrame.setMinimumSize(new Dimension(400,10));
	        newFrame.setLayout(new BorderLayout());
	        
	        JPanel main = new JPanel(new GridLayout(6,1));
	        
	        JLabel login = new JLabel(" Login :");
	        JLabel password = new JLabel(" Password :");
	        JLabel confirmPassword = new JLabel(" Confirm password :");
	        JLabel pseudo = new JLabel(" Pseudo :");
	        JLabel create = new JLabel(" Create account :");
	        JLabel error = new JLabel("");
	        
	        JTextField text1 = new JTextField();
	        text1.setPreferredSize(new Dimension(400,20));
	        JPasswordField text2 = new JPasswordField();
	        JPasswordField text3 = new JPasswordField();
	        JTextField text4 = new JTextField();
	        
	        JButton createAccount = new JButton("Create account :");
	        
	        createAccount.addActionListener(e->{
	            if(!text2.getText().equals(text3.getText())) {
	            	error.setText("Wrong password confirmation");
	            	error.setForeground(Color.RED);
	            	SwingUtilities.updateComponentTreeUI(newFrame);
	            }
	            else if(text2.getText().equals(text3.getText())){
	            	error.setText("");
	            	out.println(text1.getText());
	            	out.println(text2.getText());
	            	out.println(text4.getText());
	            	out.flush();
	            	
	            	try {
						String msgs = in.readLine();
						if(!msgs.equals("OK")) {
							error.setText(msgs);
			            	error.setForeground(Color.RED);
			            	out.println("SIGNIN");
			            	out.flush();
			            	msgs = in.readLine();
							if(!msgs.equals("OK")) {
								return;
							}
			            	SwingUtilities.updateComponentTreeUI(newFrame);
						}else {
							newFrame.setVisible(false);
							newFrame.dispose();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	            	
	            }
	        });
	        
	        
	        main.add(login);
	        main.add(text1);
	        main.add(password);
	        main.add(text2);
	        main.add(confirmPassword);
	        main.add(text3);
	        main.add(pseudo);
	        main.add(text4);
	        main.add(create);
	        main.add(createAccount);
	        main.add(error);
	        
	        newFrame.add(main);
	        newFrame.pack();
	        newFrame.setVisible(true);
	    }

}
