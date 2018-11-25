package database;

import data.User;

import java.util.ArrayList;

import data.Document;

public interface DBManager {
	public User checkCredentials(String username, String password);
	public Document checkDocument(int key);
	public ArrayList<?> getObjects();
	public void addObject(String key, Object obj);
}
