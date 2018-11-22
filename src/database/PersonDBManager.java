package database;

import java.util.HashMap;

import data.User;	//normally packages shouldn't cross-couple :/ <- but that's basically a fancy datatype, so its just like including hashmap

public class PersonDBManager implements DBManager {
	DataBaseManager DBManager;	//just a reference for right now
	HashMap<String, User> personDataBase;
	

	
	PersonDBManager() {
		//the key is the username for convienence
		personDataBase = new HashMap<String, User>();
		
		personDataBase.put(User.GuestUser, User.guest());
		
		personDataBase.put("SunJeep", new User("Satwick", "Nagam", "SunJeep", "yikes", User.Operator));	//Sunny is an operator and his aunty smells of elderberries
		personDataBase.put("LouJeep", new User("Louis", "Johnson", "LouJeep", "yeet", User.Operator));	//Louis is an operator and a richard cranium
		personDataBase.put("Kanye", new User("Keenan", "Gaudio", "Kanye", "West", User.RegisteredBuyer));	//Keenan is a registered buyer and lame
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
