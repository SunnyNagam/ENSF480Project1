
package data;

import javax.swing.JOptionPane;

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
		//System.out.println(theDocuments.getDocuments().get(0).getISBN());
		initView();
		dataManager = new DataBaseManager();	//person db by default
	}
	
	public void initView() {
		mainView = new MainView("Hey sup.", this);
		mainView.setVisible(true);
	}
	
	public void launch() {
		User thisUser = dataManager.getUser();	// this might break if its not the right dataManager

		mainView.init();
		
		handlerManager = new HandlerManager(this, thisUser);	//only create and launch a handler and mainview if you are a user, what about ordinary buyers?
		
		switchTo("Home");
		
		if (thisUser.getLastUpdated() < theDocuments.updateTime && thisUser.isSubscribed())
		{
			JOptionPane.showMessageDialog(mainView, "You have new promotions!");
		}
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
	//returns true if success
	public boolean update (int cmd, Object newObj) {
		switch (cmd) {
		case Constants.addDoc:
			Document d = (Document) newObj;
			theDocuments.addDocument(d);
			if (d.promotional) 
				theDocuments.addPromoDocument(d);
			
			break;
		case Constants.updateDoc:
			Document d2 = (Document) newObj;
			theDocuments.update(d2);
			System.out.println("yikes"+ theDocuments.getDocuments().get(0).getISBN());
			
			break;
		case Constants.deleteDoc:
			Document d3 = (Document) newObj;
			theDocuments.remove(d3);
			break;
		case Constants.purchase:
			Payment p = (Payment) newObj;
			dataManager.addTransaction(p);
			if (!theDocuments.purchase(p.docTitle, p.amountSold)) return false;
			System.out.println("Great success.");
			break;
		default:
			System.out.println("Unrecognized command");
		}
		return true;
		
	}
	
}
