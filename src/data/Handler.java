package data;

import presentation.View;
import presentation.forms.Form;

public interface Handler {
	public void interact();
	public void setupButtons(View view, Controller controller);
}
