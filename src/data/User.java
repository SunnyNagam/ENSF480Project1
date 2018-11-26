package data;

import java.util.HashMap;

public class User {
//TODO move these to the constants interface
	public static final char RegisteredBuyer = 'R';
	public static final char UnregisteredBuyer = 'U';
	public static final char OrdinaryBuyer = UnregisteredBuyer;
	public static final char Operator = 'O';
	public static final char Manager = 'M';
	public static final char ContentCreator = 'C';
	public static final char Author = ContentCreator;
	private static HashMap<Character,String> types;
	
	public static final String GuestUser = "6231ddd1382f8b858c5c3ac46fac283bf49883aab9fd357a94492380d9937ade"; 	//this is not
	public static final String GuestPass = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";	//this is the SHA-256 encryption of 'password' cause I'm hilarious
	// I aldready know 100% this is keenan, don't even have to look at the commit history
	
	private String fName;
	private String lName;	
	public String address, creditCard, cvv;
	private String userName;
	private String password;
	private char userType;	//operator, manager, etc.
	private boolean subscribed;	// for the promotions
	private long lastUpdated;
	
	public boolean isSubscribed() {
		return subscribed;
	}
	//they would also have a payment object if a registered buyer
	public User (String first, String last, String userName, String password, char userType) {
		fName = first;
		lName = last;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		lastUpdated = System.nanoTime();
		this.subscribed = (userType != UnregisteredBuyer);
	}
	public void toggleSubscription() {
		this.subscribed = !this.subscribed;
	}
	public long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public final String getUserName() {
		return userName;
	}
	
	public final String getPassword() {
		return password;
	}
	
	public final char getType() {
		return userType;
	}
	
	public static final User guest() {
		return new User ("", "", GuestUser, GuestPass, UnregisteredBuyer);
	}
	
	public final String stringType(){
		//System.out.println("Type : " + userType);
		
		if (types==null) 
			initHashyBoi();
		
		return types.get( userType );
	}
	
	private void initHashyBoi() {
		types = new HashMap<Character,String>();
		types.put(RegisteredBuyer, "Registered");
		types.put(OrdinaryBuyer, "Unregistered");
		types.put(Operator, "Operator");
		types.put(Manager, "Manager");
		types.put(Author, "Content Creator");
	}
	//access to manage inventory button
	public static boolean inventoryPrivileges(char _ut) {
		if ( _ut == Operator || _ut == Manager )
			return true;
		else
			return false;
	}
}
