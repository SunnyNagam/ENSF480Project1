package presentation.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import data.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JPanel implements Form  {

	JPanel RegisterForm;
	public JTextField username, password;
	public JButton submitButton, backButton;
	
	@Override
	public void loadForm() {
		this.removeAll();
		setLayout(new BorderLayout());
		
		RegisterForm = new JPanel();
		RegisterForm.add(new JLabel("Enter your infromation to register."));

		username = new JTextField(15);
		password = new JTextField(15);
		submitButton = new JButton("Submit");
		backButton = new JButton("Cancel");
		
		RegisterForm.add(username);
		RegisterForm.add(password);
		RegisterForm.add(submitButton);
		RegisterForm.add(backButton);
		add(RegisterForm, BorderLayout.CENTER);
		
		//return this;
		
	}

	@Override
	public Object getData() {
		User temp = new User("hi", "do i do", username.getText(), password.getText(), User.RegisteredBuyer);
		System.out.println("Query: "+temp.toString());
		return (Object) temp;
				
	}

	@Override
	public void displayResults(String something) {
		System.out.println("In register.");
	}
	@Override
	public void sendData(Object obj) {
		
	}
}
