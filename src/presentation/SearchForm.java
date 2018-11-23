package presentation;

import javax.swing.*;

public class SearchForm extends JFrame implements Form  {

	JPanel SearchForm;
	
	@Override
	public JPanel loadForm() {
		
		SearchForm = new JPanel();
		SearchForm.add(new JLabel("SEARCH"));
		
		return SearchForm;
		
	}

	
	
}
