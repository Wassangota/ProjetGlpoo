package Client.Presentation.view;

import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;

public class testMessage implements Runnable {
	
	private DefaultListModel<String> msg;
	public testMessage(DefaultListModel<String> messages) {
		// TODO Auto-generated constructor stub
		this.msg = messages;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i;
		for(i=0; i<60;i++) {
			this.msg.addElement("id="+i);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
