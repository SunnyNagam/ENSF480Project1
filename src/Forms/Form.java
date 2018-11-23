package Forms;

import javax.swing.JPanel;

public interface Form {
	
	public void loadForm();
	/*
	 * allows passing of Documents, Users, or whatever from the form
	 */
	public Object getData();
}
