package presentation.forms;

import java.awt.BorderLayout;

import javax.swing.*;

public class SearchForm extends JPanel implements Form  {

	JPanel SearchForm;
	public JTextField searchField;
	public JButton submitButton, backButton;
	
	@Override
	public void loadForm() {
		setLayout(new BorderLayout());
		
		SearchForm = new JPanel();
		SearchForm.add(new JLabel("Search Store"));

		searchField = new JTextField(15);
		submitButton = new JButton("Submit");
		backButton = new JButton("Cancel");
		SearchForm.add(searchField);
		SearchForm.add(submitButton);
		SearchForm.add(backButton);
		add(SearchForm, BorderLayout.CENTER);
		
		//return this;
		
	}

	@Override
	public Object getData() {
		// TODO get the search value, send it back to the controller to query the document DB
		return null;
	}

	
	
}
