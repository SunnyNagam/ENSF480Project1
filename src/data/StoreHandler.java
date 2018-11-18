package data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.StorePage;
import presentation.View;

public class StoreHandler implements Handler {

	@Override
	public void interact() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupButtons(View view, Controller controller) {
		StorePage gui = (StorePage) view;
		
		gui.promotionsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.err.println("Promotions clicked");
				gui.togglePromotions();
			}
		});

		gui.backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchTo("Home");
			}
		});
	}

}
