package presentation.forms;

import java.util.HashMap;

import javax.swing.JPanel;

public class FormLoader {
	HashMap<String, Form> formList;
	Form theForm;
	
	//theForm is set to searchForm, by default
	public FormLoader() {
		formList = new HashMap<String, Form>();
		
		formList.put("SearchForm", new SearchForm());
		formList.put("RegisterForm", new RegisterForm());
		formList.put("AddDocForm", new AddDocForm());
		formList.put("Order", new OrderForm());
	}
	
	public void setForm(Form newForm) {
//		if (newForm.equals("Search"))	//idk not very nice rn
//		{
//			System.out.println("set the form to search");
//			theForm = new SearchForm();
//		}
		theForm = newForm;
	}
	
	public void setForm(String name) {
		System.out.println("Switched to: "+name);
		
		theForm = formList.get(name);
		
		// more code from a desperate man
		if (name.equals("AddDocForm")) {
			formList.remove(name);
			formList.put(name, new AddDocForm());
		} else if (name.equals("Order")) {
			formList.remove(name);
			formList.put(name, new OrderForm());
		}
	}
	
	public Form runForm() {
		theForm.loadForm();
		return theForm;
	}
	
	public Object getData() {
		return theForm.getData();
	}
	
	public Form getForm() {
		return theForm;
	}
	
	public void displayResults(String val) {
		theForm.displayResults(val);
	}
}
