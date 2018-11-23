
package data;

import database.DataBaseManager;
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

	public boolean validateLogin(String userName, String password) {	// TODO actually check the Database
		// TODO: handle special case: username = "Guest" and pasword = "none"
		dataManager.runDB(userName, password);
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
