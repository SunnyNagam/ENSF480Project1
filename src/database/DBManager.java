package database;

import data.User;

public interface DBManager {
	public User checkDB(String username, String password);
}
