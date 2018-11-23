package presentation;

import javax.swing.JPanel;

public class FormLoader {
	Form theForm;
	
	//theForm is set to searchForm, by default
	FormLoader() {
		theForm = new SearchForm();
	}
	
	public void setForm(String newForm) {
		if (newForm.equals("Search"))	//idk not very nice rn
		{
			System.out.println("set the form to search");
			theForm = new SearchForm();
		}
	}
	
	public JPanel runForm() {
		return theForm.loadForm();
	}
	
}
