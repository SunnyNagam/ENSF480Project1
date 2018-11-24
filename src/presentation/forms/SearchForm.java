package presentation.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchForm extends JPanel implements Form  {

	JPanel SearchForm;
	public JTextField searchField;
	public JButton submitButton, backButton;
	public JList resultList;
	public DefaultListModel listModel;
	
	@Override
	public void loadForm() {
		setLayout(new BorderLayout());
		
		SearchForm = new JPanel();
		SearchForm.add(new JLabel("Search Store"));

		searchField = new JTextField(15);
		submitButton = new JButton("Submit");
		backButton = new JButton("Cancel");
		
		listModel = new DefaultListModel();
		resultList = new JList(listModel);
		resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultList.setSelectedIndex(0);
		resultList.setVisibleRowCount(10);
		JScrollPane listScrollPane = new JScrollPane(resultList);
		SearchForm.add(searchField);
		SearchForm.add(submitButton);
		SearchForm.add(backButton);
		SearchForm.add(listScrollPane);
		add(SearchForm, BorderLayout.CENTER);
		
		//return this;
		
	}

	@Override
	public Object getData() {
		// TODO get the search value, send it back to the controller to query the document DB
		String queryVal;
		queryVal = searchField.getText();
		return (Object) queryVal;
				
	}

	public void displayResults(String book) {
		listModel.addElement(book);
	}
	
}
