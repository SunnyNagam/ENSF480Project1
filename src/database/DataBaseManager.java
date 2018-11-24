package database;

import java.util.HashMap;

import data.Document;
import data.User;

public class DataBaseManager {
	DBManager DB;
	User u;
	Document d;
	

	public DataBaseManager() {
		DB = new PersonDBManager();	//set to person db manager by default
	}
	
	public void setStrategy(DBManager db) {
		DB = db;
	}
	
	public void resolveCredientials(String username, String password) {	//idk yet, just general strategy pattern
		
		u = DB.checkCredentials(username, password);
	}
	
	public Document getDoc(int key) {
		d = DB.checkDocument(key);
		return d;
	}
	public User getUser()
	{
		return u;
	}
}
