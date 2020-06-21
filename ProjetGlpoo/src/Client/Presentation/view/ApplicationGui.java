package Client.Presentation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import Client.Presentation.controller.MainClient;
import Client.Presentation.controller.Singletons;


public class ApplicationGui {
	
	public ApplicationGui() {
		new MainClient();
		
		JFrame mainFrame = new JFrame("Chat en ligne");
		mainFrame.setSize(new Dimension(1200,700));
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.revalidate();
		
		mainFrame.add(new HomePanel(Singletons.getOutput(),Singletons.getInput(), mainFrame));
    //mainFrame.add(new LoginPanel(null));
		
		
		//mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static void main(String args[]) {
		new ApplicationGui();
	}

}
