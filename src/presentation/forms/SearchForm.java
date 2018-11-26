package presentation.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchForm extends JPanel implements Form  {

	JPanel SearchForm, resultSetPanel;
	public JTextField searchField;
	public JButton submitButton, backButton;
	public JButton placeOrderButton;	//may be moved later- this is the button to display place-order form
	public JList resultList;
	public DefaultListModel listModel;
	
	@Override
	public void loadForm() {
		this.removeAll();
		setLayout(new BorderLayout());
		
		SearchForm = new JPanel();
		SearchForm.add(new JLabel("Search Store"));

		searchField = new JTextField(15);
		submitButton = new JButton("Submit");
		backButton = new JButton("Cancel");
		placeOrderButton = new JButton("Place Order");
		
		resultSetPanel = new JPanel();
		listModel = new DefaultListModel();
		resultList = new JList(listModel);
		resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultList.setSelectedIndex(0);
		resultList.setVisibleRowCount(5);
		JScrollPane listScrollPane = new JScrollPane(resultList);
		listScrollPane.setPreferredSize(new Dimension(350,300));
		
		SearchForm.add(searchField);
		SearchForm.add(submitButton);
		SearchForm.add(backButton);
		add(SearchForm, BorderLayout.CENTER);

		resultSetPanel.add(listScrollPane);
		resultSetPanel.add(placeOrderButton);
		add(resultSetPanel, BorderLayout.PAGE_END);

		
		//return this;
		
	}

	@Override
	public Object getData() {
		// TODO get the search value, send it back to the controller to query the document DB
		String queryVal;
		queryVal = searchField.getText();
		System.out.println("Query: "+queryVal);
		return (Object) queryVal;
				
	}

	public void displayResults(String book) {
		if (book == null)
		{
			listModel.clear();
		}
		else
		{
			listModel.addElement(book);
		}
	}
	@Override
	public void sendData(Object obj) {
		
	}
}
