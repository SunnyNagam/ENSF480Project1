package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.Document;
import data.User;	//normally packages shouldn't cross-couple :/ <- but that's basically a fancy datatype, so its just like including hashmap

public class PersonDBManager implements DBManager {
	DataBaseManager DBManager;	//just a reference for right now
	HashMap<String, User> personDataBase;
	

	
	public PersonDBManager() {
		//the key is the username for convienence
		personDataBase = new HashMap<String, User>();
		
		personDataBase.put(User.GuestUser, User.guest());
		
		personDataBase.put("a", new User("Satwick", "Nagam", "SunJeep", "a", User.Operator));	//Sunny is an operator and his aunty smells of elderberries
		personDataBase.put("SunJeep", new User("Satwick", "Nagam", "SunJeep", "yikes", User.Operator));	//Sunny is an operator and his aunty smells of elderberries
		personDataBase.put("LouJeep", new User("Louis", "Johnson", "LouJeep", "yeet", User.Operator));	//Louis is an operator and a richard cranium
		personDataBase.put("b", new User("Raymond", "Jones", "b", "b", User.RegisteredBuyer)); //reg. user with no billing info
		User k = new User("Keenan", "Gaudio", "Kanye", "West", User.RegisteredBuyer);
		k.addBillingInfo("HomeTown, CA", "123456789123", "127");
		personDataBase.put(k.getUserName(),k);	//Keenan is a registered buyer and lame

	}
	
	@Override
	public User checkCredentials(String username, String password) {
		User theUser;
			if ((theUser = personDataBase.get(username)) != null)	//check if user exists
			{
				if (theUser.getPassword().equals(password))	//password match?
				{
					return theUser;
				}
			}
		return null;
	}
	
	public User getUser(String key) {
		return personDataBase.get(key);
	}
	
	@Override
	public Document checkDocument(String key) {
		return null;
	}

	@Override
	public ArrayList<?> getObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addObject(String key, Object obj) {
		personDataBase.put(key, (User)obj);
		
	}
	

}
