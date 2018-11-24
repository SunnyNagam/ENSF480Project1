
package data;

import database.DataBaseManager;
import database.DocumentDBManager;
import presentation.MainView;

public class Controller extends Thread{
	MainView mainView;
	DataBaseManager dataManager;
	HandlerManager handlerManager;
	
	public Controller() {
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
		dataManager.setStrategy(new DocumentDBManager());	//or instead of DB use catalog?
		try {
			int query = Integer.parseInt((String) getFormData());
			if (dataManager.getDoc(query) != null)
			{
				System.out.println("Exists!");
			}
			else
			{
				System.out.println("No copies");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("No copies");

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
