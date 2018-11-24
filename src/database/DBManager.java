package database;

import data.User;
import data.Document;

public interface DBManager {
	public User checkCredentials(String username, String password);
	public Document checkDocument(int key);
}
