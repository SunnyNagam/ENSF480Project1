package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.print.attribute.HashAttributeSet;

import data.Document;
import data.User;	//normally packages shouldn't cross-couple :/ <- but that's basically a fancy datatype, so its just like including hashmap

public class PersonDBManager implements DBManager {
	DataBaseManager DBManager;	//just a reference for right now
	HashMap<String, User> personDataBase;
	

	
	public PersonDBManager() {
		//the key is the username for convienence
		personDataBase = new HashMap<String, User>();
		
		personDataBase.put(User.GuestUser, User.guest());
		
		personDataBase.put("a", new User("Satwick", "Nagam", "a", "a", User.Operator));	//Sunny is an operator and his aunty smells of elderberries
		personDataBase.put("SunJeep", new User("Satwick", "Nagam", "SunJeep", "yikes", User.Operator));	//Sunny is an operator and his aunty smells of elderberries
		personDataBase.put("LouJeep", new User("Louis", "Johnson", "LouJeep", "yeet", User.Operator));	//Louis is an operator and a richard cranium
		personDataBase.put("Kanye", new User("Keenan", "Gaudio", "Kanye", "West", User.RegisteredBuyer));	//Keenan is a registered buyer and lame
	}
	
	@Override
	public User checkCredentials(String username, String password) {
		String hashedPassword = hashPass(password, username);
		User theUser;
			if ((theUser = personDataBase.get(username)) != null)	//check if user exists
			{
				if (theUser.getPassword().equals(hashedPassword))	//password match?
				{
					return theUser;
				}
			}
		return null;
	}
	
	public static String hashPass(String password, String username) {
		String salted = password + username;
		System.out.println("Pass == "+String.valueOf(salted.hashCode()));
		return String.valueOf(salted.hashCode());
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
