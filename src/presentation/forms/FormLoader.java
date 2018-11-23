package presentation.forms;

import javax.swing.JPanel;

public class FormLoader {
	Form theForm;
	
	//theForm is set to searchForm, by default
	public FormLoader() {
		theForm = new SearchForm();
	}
	
	public void setForm(Form newForm) {
//		if (newForm.equals("Search"))	//idk not very nice rn
//		{
//			System.out.println("set the form to search");
//			theForm = new SearchForm();
//		}
		theForm = newForm;
	}
	
	public Form runForm() {
		theForm.loadForm();
		return theForm;
	}
	
}
