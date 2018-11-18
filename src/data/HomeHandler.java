package data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import presentation.HomePage;
import presentation.View;

public class HomeHandler implements Handler {

	@Override
	public void interact() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupButtons(View view, Controller controller) {
		HomePage gui = (HomePage) view;
		
		gui.storeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.err.println("Store clicked");
				controller.switchTo("Store");
			}
		});
		
		gui.manageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.err.println("Manage clicked");
				controller.switchTo("Management");
			}
		});
	}

}
