package data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import database.PersonDBManager;
import presentation.HomePage;
import presentation.StorePage;
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
				if (((StorePage) controller.mainView.currentView).showingPromotions)	//if showing promotions, turn them off
					((StorePage) controller.mainView.currentView).togglePromotions(controller.theDocuments.getPromotions());
			}
		});
		
		//view may not have created a button for manage
		if (gui.manageButton != null) gui.manageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.err.println("Manage clicked");
				controller.switchTo("Management");
				controller.mainView.currentView.updateData(controller.theDocuments.getCatalogue());
			}
		});
		
		if (gui.unsubButton != null) { 
			User temp = controller.getUser();
			if(temp.isSubscribed())
				gui.unsubButton.setText("UnSubscribe");
			else
				gui.unsubButton.setText("Subscribe");
			
			gui.unsubButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.err.println("Manage clicked");
				User temp = controller.getUser();
				temp.toggleSubscription();
				if(temp.isSubscribed())
					gui.unsubButton.setText("UnSubscribe");
				else
					gui.unsubButton.setText("Subscribe");
			}
		});
		}
		
		gui.logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.err.println("Manage clicked");
				//controller.mainView.dispatchEvent(new WindowEvent(controller.mainView, WindowEvent.WINDOW_CLOSING));
				//controller.initView();
				controller.mainView.logout(controller);
			}
		});
	}

}
