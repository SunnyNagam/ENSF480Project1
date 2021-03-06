package presentation.forms;

import javax.swing.JPanel;

public interface Form {
	
	public void loadForm();
	/*
	 * allows passing of Documents, Users, or whatever from the form
	 */
	public Object getData();
	
	public void sendData(Object obj);
	
	public void displayResults(String something);
}
