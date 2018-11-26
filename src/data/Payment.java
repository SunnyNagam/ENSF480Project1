package data;

import java.util.Date;

public class Payment {
	public double amount;
	private String creditCard;
	private String username;
	public String getCreditCard() {
		return creditCard;
	}

	public Date dateTime;
	public Payment (String cc, double amount, Date d, String user) {
		this.amount = amount;
		this.creditCard = cc.trim();
		this.dateTime = (Date) d.clone();
		this.username = user;
	}
	
	public String getCC() {
		int len = creditCard.length();
		return String.format("XXXX-XXXX-XXXX-%4s", creditCard.substring(len - 4, len));
	}
	
	public void setUser(String usr) {
		username = usr;
	}
}
