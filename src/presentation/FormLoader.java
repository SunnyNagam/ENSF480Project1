package presentation;

public class FormLoader {
	Form theForm;
	
	//theForm is set to searchForm, by default
	FormLoader() {
		theForm = new SearchForm();
	}
	
	public void setForm(Form newForm) {
		theForm = newForm;
	}
	
	public void RunForm() {
		theForm.loadForm();
	}
	
}
