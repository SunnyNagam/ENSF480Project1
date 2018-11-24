
package data;

import database.DataBaseManager;
import database.DocumentDBManager;
import presentation.MainView;

public class Controller extends Thread{
	DocumentCatalog theDocuments;
	MainView mainView;
	DataBaseManager dataManager;
	HandlerManager handlerManager;
	
	public Controller(DocumentCatalog theDocuments) {
		this.theDocuments = theDocuments;
		System.out.println(theDocuments.getDocuments().get(0).getISBN());
		initView();
		dataManager = new DataBaseManager();	//person db by default
	}
	
	public void initView() {
		mainView = new MainView("Hey sup.", this);
		mainView.setVisible(true);
	}
	
	public void launch() {
		User thisUser = dataManager.getUser();
		
		mainView.init();
		
		handlerManager = new HandlerManager(this, thisUser);	//only create and launch a handler and mainview if you are a user, what about ordinary buyers?
		
		switchTo("Home");
	}
	public final User getUser() {
		return dataManager.getUser();
	}
	
	public void switchTo(String page) {
		// switch the gui to that page
		// page names are {type}Page : {userString}
		String _utString = getUser().stringType();
		mainView.switchWindow(page+"Page : " + _utString);
		// switch the handler
		handlerManager.switchHandler(page+"Handler");
		// switch the database?
	}
	
	public void loadForm(String page) {
		//produce a form based on button input
		//mainView.formloader.setForm(page);
		mainView.produceForm(page);//load the form onto view
	}
	//this assumes that the correct DB is set when you switched to storepage(document DB)
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
		mainView.formloader.displayResults(null);	//clear the list
		for (int i = 0; i < theDocuments.getDocuments().size(); i++) {
			if (theDocuments.getDocuments().get(i).getISBN().equals((String) getFormData()))
			{
				System.out.println("Success");
				mainView.formloader.displayResults(theDocuments.getDocuments().get(i).toString());
				break;
			}
		}
		
		System.out.println((String) getFormData());
		
	}
	
	private Object getFormData() {
		return mainView.formloader.getData();
	}
	
	

	public boolean validateLogin(String userName, String password) {
		// TODO: handle special case: username = "Guest" and pasword = "none"
		dataManager.resolveCredientials(userName, password);
		if (dataManager.getUser() != null)
		{
			return true;
		}
		else
		{
			return false;
		}
		/*
		if(userName.equals("SunJeep") && password.equals("Rulez"))
			return true;
		else
			return false;*/
	}
	
}
