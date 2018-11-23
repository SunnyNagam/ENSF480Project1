package presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Controller;
import data.User;


public class LoginPage extends JPanel implements View {
	
	private static LoginPage instance;
	
	public JTextField userNameField, passwordField;
	public JLabel uNameLab, passLab, introLab;
	public JButton submitButton, guestButton;
	
	public LoginPage(Controller main) {
		// TODO Auto-generated constructor stub
		userNameField = new JTextField(10);
		passwordField = new JTextField(10);
		uNameLab = new JLabel("UserName:");
		passLab = new JLabel("Password:");
		introLab = new JLabel("Login to your publication system!!");
		submitButton = new JButton("Submit");
		guestButton = new JButton("Continue as Guest");

		setLayout(new BorderLayout());
		
		JPanel logPan = new JPanel();
		logPan.add(uNameLab);
		logPan.add(userNameField);
		logPan.add(passLab);
		logPan.add(passwordField);
		
		add(logPan, BorderLayout.CENTER);
		
		JPanel topPan = new JPanel();
		topPan.add(introLab);
		
		add(topPan, BorderLayout.PAGE_START);
		
		JPanel botPan = new JPanel();
		botPan.add(submitButton);
		botPan.add(guestButton);
		
		add(botPan, BorderLayout.PAGE_END);
		
		initLoginButton(main);
	}
	private void initLoginButton(Controller main) {
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = userNameField.getText();
				String password = passwordField.getText();
				
				boolean validLogin = main.validateLogin(userName, password);
				
				if(validLogin) {
					main.launch();
				}
				else {
					JOptionPane.showMessageDialog(null, ("Error, you entered "+ userName+" and "+ password+" (PersonDB says:\n"
							+ "usernames: SunJeep, LouJeep, Kanye\n"
							+ "pass: yikes, yeet, West)"));
				}
			}
		});
		
		guestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = User.GuestUser;
				String password = User.GuestPass;
				
				boolean validLogin = main.validateLogin(userName, password);	// build special case
				
				main.launch();
			}
		});
	}
	
	public static LoginPage getLoginPage(Controller main) {
		if(instance == null) {
			instance = new LoginPage(main);
		}
		
		return instance;
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
