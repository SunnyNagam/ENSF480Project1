package database;

import java.util.HashMap;

import data.User;

public class DataBaseManager {
	DBManager DB;
	User u;
	

	public DataBaseManager() {
		DB = new PersonDBManager();	//set to person db manager by default
	}
	
	public void setStrategy(DBManager db) {
		DB = db;
	}
	
	public void runDB(String username, String password) {	//idk yet, just general strategy pattern
		u = DB.checkDB(username, password);
	}
	public User getUser()
	{
		return u;
	}
}
