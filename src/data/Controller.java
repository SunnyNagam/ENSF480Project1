package data;

import database.DataBaseManager;
import presentation.MainView;

public class Controller extends Thread{
	MainView mainView;
	DataBaseManager dataManager;
	HandlerManager handlerManager;
	
	public Controller() {
		mainView = new MainView("Hey sup.", this);
		mainView.setVisible(true);
		dataManager = new DataBaseManager();	//person db by default
	}
	
	public void launch() {
		mainView.init();
		handlerManager = new HandlerManager(this);	//only create and launch a handler and mainview if you are a user, what about ordinary buyers?
		switchTo("Home");
	}
	
	public void switchTo(String page) {
		// switch the gui to that page
		mainView.switchWindow(page+"Page");
		// switch the handler
		handlerManager.switchHandler(page+"Handler");
		// switch the database?
	}

	public boolean validateLogin(String userName, String password) {	// TODO actually check the Database
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
