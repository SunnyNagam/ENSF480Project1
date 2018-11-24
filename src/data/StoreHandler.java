package data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.StorePage;
import presentation.View;
import presentation.forms.Form;
import presentation.forms.SearchForm;

public class StoreHandler implements Handler {

	private Controller controller;
	@Override
	public void interact() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupButtons(View view, Controller controller) {
		this.controller = controller;
		StorePage gui = (StorePage) view;
		
		if (gui.promotionsButton != null) gui.promotionsButton.addActionListener(new ActionListener() {
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
		
		gui.searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.loadForm("Search");	//will call mainview to takeover
				setupFormButtons(controller.mainView.formloader.getForm());
			}
		});
		
//		SearchForm searchForm = new SearchForm();	//janky but just trying to get a running copy
//		searchForm.loadForm();
//		searchForm.submitButton.addActionListener(new ActionListener() {
//			//put in store handler - connect handler with form
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("pressed submit");
//				controller.resolveSearch();
//			}
//		});
	}
	
	public void setupFormButtons(Form theForm) {
		SearchForm form = (SearchForm) theForm;
		
		form.submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pressed submit");
				controller.resolveSearch();
			}
		});
	}

}
