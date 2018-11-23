package presentation;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManagementPage extends JPanel implements View{
	public JButton backButton;	//probably shouldn't make these public?
	
	public ManagementPage() {
		// TODO Auto-generated constructor stub
		JLabel test = new JLabel("Test");
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.add(test);
		panel.add(backButton = new JButton("Back"));
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
	}
}
