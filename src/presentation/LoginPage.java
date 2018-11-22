package presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
	public JButton submitButton, unregButton;
	
	public LoginPage(Controller main) {
		// TODO Auto-generated constructor stub
		userNameField = new JTextField(10);
		passwordField = new JTextField(10);
		uNameLab = new JLabel("UserName:");
		passLab = new JLabel("Password:");
		introLab = new JLabel("Login to your publication system!!");
		submitButton = new JButton("Submit");
		unregButton = new JButton("Proceed as Guest");

		setLayout(new BorderLayout());
		
		JPanel logPan = new JPanel();
		logPan.add(uNameLab);
		logPan.add(userNameField);
		logPan.add(passLab);
		logPan.add(passwordField);
		
		add(logPan, BorderLayout.CENTER);
		
		JPanel topPan = new JPanel();
		topPan.add(introLab);
		
		add(topPan, BorderLayout.NORTH);
		
		JPanel botPan = new JPanel();
		botPan.setLayout(new BoxLayout(botPan, BoxLayout.Y_AXIS));
		botPan.add(submitButton);
		
		botPan.add(unregButton);
		
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
		
		unregButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean validLogin = main.validateLogin(User.GuestUser, User.GuestPass);
				
				if (validLogin) {
					main.launch();
				} else {
					//Error connecting to DB
					JOptionPane.showMessageDialog(null, ("Error, you entered as a guest, but there has been an issue try a login instead\n (PersonDB says:\n"
							+ "usernames: SunJeep, LouJeep, Kanye\n"
							+ "pass: yikes, yeet, West)"));
				}
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

}
