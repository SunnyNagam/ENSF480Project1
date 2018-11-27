package data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import database.PersonDBManager;
import presentation.StorePage;
import presentation.View;
import presentation.forms.AddDocForm;
import presentation.forms.Form;
import presentation.forms.RegisterForm;
import presentation.forms.SearchForm;
import presentation.forms.OrderForm;

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
				if (controller.getUser().isSubscribed()) {
					gui.togglePromotions( controller.theDocuments.getPromotions() );
					controller.getUser().setLastUpdated(System.nanoTime());
				}
				else {
					JOptionPane.showMessageDialog(controller.mainView, "Please register to view promotions.");
				}
			}
		});
		
		if (gui.registerButton != null) gui.registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			System.err.println("Register clicked");
			controller.loadForm("Register");	//will call mainview to takeover
				setupRegisterFormButtons(controller.mainView.formloader.getForm());
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
				setupSearchFormButtons(gui, controller.mainView.formloader.getForm());
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
	
	public void setupSearchFormButtons(View gui, Form theForm) {
		SearchForm form = (SearchForm) theForm;
		
		form.submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resolveSearch();
			}
		});
		
		form.backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchTo("Store");
				if (((StorePage) gui).showingPromotions)	//if showing promotions, turn them off
					((StorePage) gui).togglePromotions(controller.theDocuments.getPromotions());
			}
		});
		form.placeOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.loadForm("Order");
				OrderForm order = (OrderForm) controller.mainView.formloader.getForm();
				setupOrderFormButtons(order, gui);
				order.sendData(controller.getUser());
				order.sendData(form.resultList.getSelectedValue()); //returns a string
				//((OrderForm) controller.mainView.formloader.getForm()).
				//TODO idk
			}
		});
	}
	
	protected void setupOrderFormButtons(OrderForm form, View gui) {
		// TODO buttons place order
		form.submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed buy button");
				//register((User)form.getData());
				//TODO order
			}
		});
		
		form.backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed back button");
				controller.loadForm("Search");	//will call mainview to takeover
				setupSearchFormButtons(gui, controller.mainView.formloader.getForm());
			}
		});
	}

	public void setupRegisterFormButtons(Form theForm) {
		RegisterForm form = (RegisterForm) theForm;
		
		form.submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				register((User)form.getData());
			}
		});
		
		form.backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchTo("Store");
				if (((StorePage) controller.mainView.currentView).showingPromotions)	//if showing promotions, turn them off
					((StorePage) controller.mainView.currentView).togglePromotions(controller.theDocuments.getPromotions());
			}
		});
	}
	
	public void register(User user) {		// TODO warning this function is super sketch and horrible for nwo
		User newUser = (User) controller.mainView.formloader.getData();
		//TODO: add to DB
		controller.dataManager.addObject(user.getUserName(), user);	// TODO check if it's person database
		System.out.println("Adding: "+user.getUserName()+", "+user.getPassword());
		controller.mainView.dispose();
		controller.initView();
		//(PersonDBManager)((controller.dataManager))
	}

	public void resolveSearch() {
//		dataManager.setStrategy(new DocumentDBManager());	//or instead of DB use catalog?
//		try {
//			int query = Integer.parseInt((String) getFormData());
//			if (dataManager.getDoc(query) != null)
//			{
//				Document theDocument = dataManager.getDoc(query);
//				mainView.formloader.displayResults(theDocument.toString());
//			}
//			else
//			{
//				System.out.println("No copies");
//			}
//		}
//		catch (NumberFormatException e)
//		{
//			System.out.println("No copies");
//
//		}
		//int query = Integer.parseInt((String) getFormData());
		controller.mainView.formloader.displayResults(null);	//clear the list
		for (int i = 0; i < controller.theDocuments.getDocuments().size(); i++) {
			if (controller.theDocuments.getDocuments().get(i).getISBN().equals((String) getFormData()) ||
					controller.theDocuments.getDocuments().get(i).getTitle().contains((String) getFormData()) ||
					controller.theDocuments.getDocuments().get(i).getContents().contains((String) getFormData()) ||
					controller.theDocuments.getDocuments().get(i).getAuthors().contains((String) getFormData()) )
			{
				System.out.println("Success");
				controller.mainView.formloader.displayResults(controller.theDocuments.getDocuments().get(i));
				//break;
			}
		}
		
		System.out.println((String) getFormData());
		
	}
	
	private Object getFormData() {
		return controller.mainView.formloader.getData();
	}
	
	

}
