package data;

import presentation.View;

public interface Handler {
	public void interact();
	public void setupButtons(View view, Controller controller);
}
