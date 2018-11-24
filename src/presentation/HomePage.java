package presentation;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.User;

public class HomePage extends JPanel implements View{
	
	public JButton storeButton, manageButton, logoutButton;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		JLabel test = new JLabel("HomePage Test");
		setLayout(new BorderLayout());
				
		JPanel panel = new JPanel();
		panel.add(test);
				
		add(panel, BorderLayout.CENTER);
		
		
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public char userType;
	@Override 
	public void setUserType(char _ut) {
		userType = _ut;
		
		JPanel botPan = new JPanel();
		botPan.add(storeButton = new JButton("View Store"));
		
		if ( User.inventoryPrivileges(_ut) )
			botPan.add(manageButton = new JButton("Manage Inventory"));
		
		if ( userType == User.UnregisteredBuyer)
			botPan.add(logoutButton = new JButton("Login"));
		else
			botPan.add(logoutButton = new JButton("Logout"));
		
		add(botPan, BorderLayout.PAGE_END);
	}
	@Override
	public void updateData(ArrayList<Object> arr) {
		
	}
}
