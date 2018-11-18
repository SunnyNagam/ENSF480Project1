package data;

public class User {
	private String fName;
	private String lName;	
	private String userName;
	private String password;
	private char userType;	//operator, manager, etc.
	//they would also have a payment object if a registered buyer
	public User (String first, String last, String userName, String password, char userType) {
		fName = first;
		lName = last;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
}
