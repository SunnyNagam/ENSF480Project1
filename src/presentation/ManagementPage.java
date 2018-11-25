package presentation;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ManagementPage extends JPanel implements View{
	public JButton backButton;	//probably shouldn't make these public?
	public JButton addButton, editButton, deleteButton;
	
	public ManagementPage() {
		// TODO Auto-generated constructor stub
		JLabel test = new JLabel("This is the window\nfor viewing Documents,\nall of them");
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.add(test);
		
		add(panel, BorderLayout.CENTER);
		buttons();
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
	@Override
	public void updateData(ArrayList<Object> arr) {
	
	}

	private void buttons () {
		JPanel botPan = new JPanel();
		botPan.add(backButton = new JButton("Back"));

		JPanel topPan = new JPanel();
		
		topPan.add(addButton = new JButton("Add"));
		
		topPan.add(editButton = new JButton("Edit"));
		
		topPan.add(deleteButton = new JButton("Delete"));
			
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		
		p.add(topPan);
		p.add(new JSeparator(SwingConstants.HORIZONTAL));
		p.add(botPan);
		
		add(p, BorderLayout.PAGE_END);
	}
}
