package database;

import java.util.HashMap;

import data.User;	//normally packages shouldn't cross-couple :/
public class PersonDBManager implements DBManager {
	DataBaseManager DBManager;	//just a reference for right now
	HashMap<String, User> personDataBase;
	

	
	PersonDBManager() {
		//the key is the username for convienence
		personDataBase = new HashMap<String, User>();
		personDataBase.put("SunJeep", new User("Satwick", "Nagam", "SunJeep", "yikes", 'O'));	//Sunny is an operator
		personDataBase.put("LouJeep", new User("Louis", "Johnson", "LouJeep", "yeet", 'O'));	//Louis is an operator
		personDataBase.put("Kanye", new User("Keenan", "Gaudio", "Kanye", "West", 'R'));	//Keenan is a registered buyer and lame
		
	}
	
	@Override
	public User checkDB(String username, String password) {
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
	

}
