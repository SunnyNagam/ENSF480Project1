package database;

import java.util.ArrayList;
import java.util.HashMap;

import data.Document;
import data.Payment;
import data.User;

public class DataBaseManager {
	DBManager DB;
	User u;
	Document d;
	
	//this is the transaction DB, for now
	ArrayList<Payment> transactionRecord;
	

	public DataBaseManager() {
		DB = new PersonDBManager();	//set to person db manager by default
		transactionRecord = new ArrayList<Payment>();
	}
	
	public void setStrategy(DBManager db) {
		DB = db;
	}
	
	public void resolveCredientials(String username, String password) {	//idk yet, just general strategy pattern
		
		u = DB.checkCredentials(username, password);
	}
	
	public Document getDoc(String key) {
		d = DB.checkDocument(key);
		return d;
	}
	
	public ArrayList<?> getObjects() {
		return DB.getObjects();
	}
	
	public User getUser()
	{
		return u;
	}
	
	public void addObject(String key, Object obj) {
		DB.addObject(key, obj);
	}
	
	public void addTransaction(Payment p) {
		transactionRecord.add(p);
	}
}
