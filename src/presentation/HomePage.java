package presentation;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JPanel implements View{
	public JButton storeButton, manageButton, logoutButton;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		JLabel test = new JLabel("HomePage Test");
		setLayout(new BorderLayout());
				
		JPanel panel = new JPanel();
		panel.add(test);
				
		add(panel, BorderLayout.CENTER);
		
		JPanel botPan = new JPanel();
		botPan.add(storeButton = new JButton("View Store"));
		botPan.add(manageButton = new JButton("Manage Inventory"));
		botPan.add(logoutButton = new JButton("Logout"));
		
		add(botPan, BorderLayout.PAGE_END);
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
